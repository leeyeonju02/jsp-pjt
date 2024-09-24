package com.jsp.jsp_pjt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.jsp_pjt.user.dao.UserMapper;
import com.jsp.jsp_pjt.user.domain.UserRequestDTO;
import com.jsp.jsp_pjt.user.domain.UserResponseDTO;

import java.util.UUID; //파일 이름 랜덤하게 만들어줌
import java.io.File;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    public UserResponseDTO login(UserRequestDTO params){
        System.out.println("debug >>> UserService login ");
        return userMapper.loginRow(params);
    }

    public void join(UserRequestDTO params, MultipartFile file){
        System.out.println("debug >>> UserService join ");
        System.out.println("debug >>> upload img : "+ file.getOriginalFilename());
        // userMapper.joinRow(params);

        String path = "/Users/leeyeonju/Documents/jsp-pjt/src/main/resources/static/img";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid+"_"+file.getOriginalFilename();

        System.out.println("debug >>> upload uuid img : "+fileName);

        // 이미지를 지정 디렉토리 밑에 파일이름으로 저장
        File saveFile = new File(path, fileName);
        try{
            file.transferTo(saveFile);
        } catch (Exception e){
            e.printStackTrace();
        }
        params.setImgUrl(fileName);
        userMapper.joinRow(params);

    }


}