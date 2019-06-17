package com.frank.domain.one;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.frank.domain.one")
public class DomainOneApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DomainOneApplication.class).run(args);
    }
}
