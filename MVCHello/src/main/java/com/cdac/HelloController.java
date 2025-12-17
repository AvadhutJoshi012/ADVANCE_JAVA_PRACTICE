package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("/hello")  // this the only name that we put in the url when we run the project we can write anything here like welcome or hi but we have to give this name in the url when we run the project 
    public String hello(Model model) {
        model.addAttribute("message", "Hello World from Spring MVC");
        return "hello";     // and this the hello.jsp file calling 
    }
}
