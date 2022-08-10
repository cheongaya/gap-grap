package com.roovalant.gapgrap;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@AllArgsConstructor
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class GapGrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(GapGrapApplication.class, args);
    }

}
