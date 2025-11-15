package com.lestonpoh.financeapp_backend.model.ibkr.generateIbkrApiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "FlexStatementResponse")
public class FlexStatementResponseDTO {
    @JacksonXmlProperty(localName = "Status")
    private String status;

    @JacksonXmlProperty(localName = "ReferenceCode")
    private String referenceCode;

    @JacksonXmlProperty(localName = "Url")
    private String url;
}
