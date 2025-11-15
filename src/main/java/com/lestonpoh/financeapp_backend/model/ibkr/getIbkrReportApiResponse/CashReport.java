package com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashReport {

    @JacksonXmlProperty(localName = "CashReportCurrency")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CashReportCurrency> cashReportCurrencyList;

    // Getters & Setters...
}