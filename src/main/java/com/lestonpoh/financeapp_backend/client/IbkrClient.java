package com.lestonpoh.financeapp_backend.client;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lestonpoh.financeapp_backend.model.ibkr.generateIbkrApiResponse.FlexStatementResponseDTO;
import com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse.FlexQueryResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class IbkrClient {

    @Value("${ibkr.urls.generateReport}")
    private String generateReportBaseUrl;
    @Value("${ibkr.urls.getReport}")
    private String getReportBaseUrl;
    @Value("${ibkr.secrets.flexToken}")
    private String flexToken;
    @Value("${ibkr.secrets.flexQueryId}")
    private String flexQueryId;

    private final WebClient webClient;
    private final XmlMapper xmlMapper;

    public String generateReport() {
        String url = String.format(
                "%s?v=3&t=%s&q=%s",
                generateReportBaseUrl, flexToken, flexQueryId);

        log.info("Requesting report from ibkr... ");
        String responseXml = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            FlexStatementResponseDTO response = xmlMapper.readValue(responseXml, FlexStatementResponseDTO.class);
            System.out.println(response);

            return response.getReferenceCode();
        } catch (Exception e) {
            throw new RuntimeException("Cannot parse response to json");
        }
    }

    public FlexQueryResponseDTO getReport(String referenceCode) throws IOException {
        String url = String.format(
                "%s?v=3&t=%s&q=%s",
                getReportBaseUrl, flexToken, "3749292210");

        String responseXml = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            FlexQueryResponseDTO response = xmlMapper.readValue(responseXml, FlexQueryResponseDTO.class);
            ObjectMapper jsonMapper = new ObjectMapper();
            System.out.println(response);
            // System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Cannot parse response to json");
        }
    }

}
