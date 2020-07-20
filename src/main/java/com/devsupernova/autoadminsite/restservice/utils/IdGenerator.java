package com.devsupernova.autoadminsite.restservice.utils;

import java.util.UUID;

public final class IdGenerator {
    private IdGenerator(){}

    public static String  generate(){
        return UUID.randomUUID().toString();
    }
}
