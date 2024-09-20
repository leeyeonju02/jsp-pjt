package com.jsp.jsp_pjt.board.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/board")
public class BoardController {
    
    @GetMapping("/list.multicampus")
    public String list() {
        System.out.println("debug >>> BoardController user endpoint : /board/list.multicompus");
        return "listPage";
    }
    
}
