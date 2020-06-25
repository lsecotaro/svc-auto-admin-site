package com.example.restservice;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class MyCustomMenuItem {
    private final String name;
}
