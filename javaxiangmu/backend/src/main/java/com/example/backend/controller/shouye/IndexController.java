package com.example.backend.controller.shouye;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/shouye")
    public String index(){
        return "dist/index.html";
    }
}
