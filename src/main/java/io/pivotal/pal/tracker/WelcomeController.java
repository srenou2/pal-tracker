package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    public WelcomeController (String myMessage) {
        this.message = myMessage;
    }
    public WelcomeController () {
        this.message = "";
    }

    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }
    @Value("${WELCOME_MESSAGE}")
    void setMessage(String myMessage) {
        this.message=myMessage;
    }
    private String message;
}