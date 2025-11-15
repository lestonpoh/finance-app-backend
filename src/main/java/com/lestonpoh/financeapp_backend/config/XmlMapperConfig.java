package com.lestonpoh.financeapp_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Configuration
public class XmlMapperConfig {
    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }
}
