package com.devsupernova.autoadminsite.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class StartUpConfig {
    @Bean
    public HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
//        headers.setAccessControlAllowMethods(Arrays.asList(HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE, HttpMethod.OPTIONS));
//        headers.setAccessControlAllowHeaders(Arrays.asList("Content-Type"));
//        headers.setAccessControlMaxAge(86400);
//        headers.setAccessControlAllowOrigin("localhost:3000, localhost");
        return headers;
    }
}
