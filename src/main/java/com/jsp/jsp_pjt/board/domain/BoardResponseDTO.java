package com.jsp.jsp_pjt.board.domain;

import lombok.Data;

@Data
public class BoardResponseDTO {
    private Integer bno;
    private String  title;
    private String  content;
    private String  regdate;
    private Integer viewcnt;
    private String  writer;

}
