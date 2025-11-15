package com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashReportCurrency {

    @JacksonXmlProperty(isAttribute = true, localName = "slbNetCash")
    private String netCash;

    @JacksonXmlProperty(isAttribute = true, localName = "currency")
    private String currency;
}