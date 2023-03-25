package com.example.backend.controller.shouye;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController//Rest一定要写
@RequestMapping("/index")
public class loginViewController {
    @RequestMapping("/ceshi")
    public Map<String,String> get(){
        Map<String,String> count=new HashMap<>();
        count.put("countname","lse");
        count.put("password","lc210085");
        return count;
    }

}
