package com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenPosition {

    @JacksonXmlProperty(isAttribute = true, localName = "currency")
    private String currency;

    @JacksonXmlProperty(isAttribute = true, localName = "symbol")
    private String symbol;

    @JacksonXmlProperty(isAttribute = true, localName = "description")
    private String description;

    @JacksonXmlProperty(isAttribute = true, localName = "position")
    private String position;

    @JacksonXmlProperty(isAttribute = true, localName = "positionValue")
    private String positionValue;

    @JacksonXmlProperty(isAttribute = true, localName = "costBasisPrice")
    private String costPrice;

    @JacksonXmlProperty(isAttribute = true, localName = "markPrice")
    private String averagePurchasePrice;

    @JacksonXmlProperty(isAttribute = true, localName = "fifoPnlUnrealized")
    private String unrealisedGains;
}