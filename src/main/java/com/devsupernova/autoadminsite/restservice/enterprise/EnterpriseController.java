package com.devsupernova.autoadminsite.restservice.enterprise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/enterprise")
@CrossOrigin(origins={"http://localhost:3000","https://web-iu.herokuapp.com/"})
@RequiredArgsConstructor
@Slf4j
public class EnterpriseController {
    private final EnterpriseService service;
    private final HttpHeaders responseHeaders;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getEnterprises());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Enterprise> saveEnterprises(@RequestBody Enterprise enterprise){
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.upsert(enterprise));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> saveEnterprises(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .build();
    }
}
