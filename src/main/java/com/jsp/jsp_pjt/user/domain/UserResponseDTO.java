package com.jsp.jsp_pjt.user.domain;

import lombok.Data;

@Data
public class UserResponseDTO {
    private String id;
    private String pwd;
    private String name; 
    private Integer point;
    private String imgUrl;
}
