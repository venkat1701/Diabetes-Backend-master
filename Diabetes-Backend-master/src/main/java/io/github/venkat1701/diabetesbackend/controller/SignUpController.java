package io.github.venkat1701.diabetesbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    @ResponseBody
    public String signup() {
        return "Welcome Signup";
    }


}
