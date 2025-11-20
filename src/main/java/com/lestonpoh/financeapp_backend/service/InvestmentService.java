package com.lestonpoh.financeapp_backend.service;

import org.springframework.stereotype.Service;

import com.lestonpoh.financeapp_backend.client.IbkrClient;
import com.lestonpoh.financeapp_backend.mapper.ibkr.IbkrMapper;
import com.lestonpoh.financeapp_backend.model.dao.UserAccounts;
import com.lestonpoh.financeapp_backend.model.ibkr.IbkrInfoDTO;
import com.lestonpoh.financeapp_backend.model.ibkr.IbkrReportDTO;
import com.lestonpoh.financeapp_backend.repository.UserAccountsRepository;
import com.lestonpoh.financeapp_backend.utility.CryptoUtil;
import com.lestonpoh.financeapp_backend.utility.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestmentService {
    private final IbkrClient ibkrClient;
    private final IbkrMapper ibkrMapper;
    private final UserAccountsRepository userAccountsRepository;
    private final CryptoUtil cryptoUtil;

    public IbkrReportDTO getIbkrReport() {
        UserAccounts userAccounts = userAccountsRepository.findByUserId(SecurityUtil.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("No user_accounts found"));

        String token;
        String queryId;

        if (userAccounts.getIbkr() != null) {
            token = userAccounts.getIbkr().getToken();
            queryId = userAccounts.getIbkr().getQueryId();
            if (token == null || queryId == null) {
                throw new RuntimeException("Ibkr info invalid");
            }
        } else {
            throw new RuntimeException("Ibkr info invalid");
        }

        try {
            token = cryptoUtil.decrypt(token);
            queryId = cryptoUtil.decrypt(queryId);
        } catch (Exception e) {
            throw new RuntimeException("unable to decrypt token");
        }

        String referenceCode = ibkrClient.generateReport(queryId, token);
        return ibkrMapper.toIbkrReportDTO(ibkrClient.getReport(token, referenceCode));
    }

    public void updateIbkrInfo(IbkrInfoDTO request) {
        String currentuserId = SecurityUtil.getCurrentUserId();

        // hash the info
        try {
            request.setQueryId(cryptoUtil.encrypt(request.getQueryId()));
            request.setToken(cryptoUtil.encrypt(request.getToken()));
        } catch (Exception e) {
            throw new RuntimeException("unable to encrypt tokens");
        }

        UserAccounts userAccounts = userAccountsRepository.findByUserId(currentuserId)
                .orElse(UserAccounts.builder()
                        .userId(currentuserId).build());
        userAccounts.setIbkr(request);
        System.out.println(userAccounts);

        userAccountsRepository.save(userAccounts);
    }
}
