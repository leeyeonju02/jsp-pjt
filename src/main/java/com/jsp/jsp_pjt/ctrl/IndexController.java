package com.jsp.jsp_pjt.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {
    /*
     * 필요에 따라서 메서드가 파라미터 값을 전달 받을 때 
     */
     @GetMapping("/index.multicampus")
     public String index() {
        System.out.println("debug >>> indexController user endpoint : /index.multicampus");
        return "index"; //페이지 이름이 문자열로 반환된다. 
     }
     
}
