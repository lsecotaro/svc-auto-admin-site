package com.devsupernova.autoadminsite.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class StartUpConfig {
    @Bean
    public HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        return headers;
    }
}