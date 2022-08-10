package com.roovalant.gapgrap.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class i18nController {

    @GetMapping("/i18n")
    public String getMultiLanguage() {
        return "test";
    }
}
