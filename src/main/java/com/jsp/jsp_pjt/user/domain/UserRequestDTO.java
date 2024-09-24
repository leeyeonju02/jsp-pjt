package com.jsp.jsp_pjt.user.domain;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank(message = "아이디는 필수 입력사항입니다. ") //유효성 검증 
    private String id;
    @NotBlank(message = "비밀번호는 필수 입력사항입니다. ")
    private String pwd; 
    @NotBlank(message = "이름은 필수 입력사항입니다. ")
    private String name; 
    //param과 테이블 이름과 동일 해야한다

    private String imgUrl;
}
