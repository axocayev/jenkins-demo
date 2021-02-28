package az.atlacademy.demojenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping
    public String home(){
        return "Jenkins tutorial  some new text addded";

    }
    @GetMapping(value = "/test")
    public String test(){
        return "TEST DEMO JENKINS";

    }
}
