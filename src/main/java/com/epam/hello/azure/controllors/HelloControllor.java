package com.epam.hello.azure.controllors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllor {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",defaultValue = "azure") String name){
        return "Hi" + name + " this is demo for jenkins and azure app service integration.";
    }

}
