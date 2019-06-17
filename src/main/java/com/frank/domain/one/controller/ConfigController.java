package com.frank.domain.one.controller;

import com.frank.configclient.event.ConfigChangeRemoteApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private Environment environment;

    @Value("spring.application.name")
    private String originService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @GetMapping("")
    public String getConfigByKey(){
        return environment.getProperty("name");
    }

    @GetMapping("/publish")
    public String publish(@RequestParam("configValue") String nameValue){
        ConfigChangeRemoteApplicationEvent configChangeRemoteApplicationEvent =
                new ConfigChangeRemoteApplicationEvent(this, originService, "", nameValue);
        applicationEventPublisher.publishEvent(configChangeRemoteApplicationEvent);
        return "publish success";
    }
}
