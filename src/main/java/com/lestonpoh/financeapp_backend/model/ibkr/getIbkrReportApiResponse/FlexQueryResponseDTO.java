package com.lestonpoh.financeapp_backend.model.ibkr.getIbkrReportApiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "FlexQueryResponse")
public class FlexQueryResponseDTO {

    @JacksonXmlProperty(localName = "FlexStatements")
    private FlexStatements flexStatements;
}