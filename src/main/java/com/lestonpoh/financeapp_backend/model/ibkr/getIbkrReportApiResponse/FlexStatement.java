package com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlexStatement {

    @JacksonXmlProperty(localName = "CashReport")
    private CashReport cashReport;

    @JacksonXmlProperty(localName = "OpenPositions")
    private OpenPositions openPositions;
}