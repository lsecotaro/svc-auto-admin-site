package com.devsupernova.autoadminsite.restservice;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
public class CustomMenu {
    private final List<MyCustomMenuItem> items;
}
