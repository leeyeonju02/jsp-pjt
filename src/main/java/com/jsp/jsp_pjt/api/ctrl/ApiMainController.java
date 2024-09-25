package com.jsp.jsp_pjt.api.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/naver/api")
public class ApiMainController {
    
    @GetMapping("/search")
    public String getMethodName(@RequestParam(value = "param", required = false, defaultValue = "default_value") String param) {
        System.out.println("debug >>> user endpoint : /naver/api/search");

        return "search_api";
    }
    
}
