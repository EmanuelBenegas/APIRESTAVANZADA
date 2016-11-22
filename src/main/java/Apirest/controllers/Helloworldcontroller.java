package Apirest.controllers;

/**
 * Created by lcc on 21/11/2016.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Helloworldcontroller {
    @RequestMapping("/")
    @ResponseBody
    public String sayHelloWorld() {
        return "Hello World in your SpringBoot Application!";
    }
}
