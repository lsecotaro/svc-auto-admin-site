package com.devsupernova.autoadminsite.restservice.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    @GetMapping("/menu")
    public ResponseEntity<CustomMenu> menu() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(mockMenu());
    }

    private CustomMenu mockMenu() {
        List<MyCustomMenuItem> items = new ArrayList<>();
        items.add(MyCustomMenuItem.builder()
                .name("Productos")
                .build());
        items.add(MyCustomMenuItem.builder()
                .name("Nosotros")
                .build());
        items.add(MyCustomMenuItem.builder()
                .name("Contactos")
                .build());
        return CustomMenu.builder()
                .items(items)
                .build();
    }
}
