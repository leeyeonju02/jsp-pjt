package com.jsp.jsp_pjt.api.ctrl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.jsp_pjt.api.domain.SearchDTO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Value("${naver.client-id}")
    private String client;

    @Value("${naver.secret}")
    private String secret;

    @GetMapping("/naver/local/{name}")
public ResponseEntity<List<SearchDTO>> local(@PathVariable("name") String name) {
    System.out.println("debug >>> user endpoint : /api/naver/local/{name}");
    System.out.println("debug >>> params = " + name);
    List<SearchDTO> list = search(name);
    return new ResponseEntity<>(list, HttpStatus.OK);
}

    //api  이용하여 장소 검색 반환 역할
    //  한글 인코딩 필수
    // ObjectMapper(json -> dto)
    public List<SearchDTO> search(String query){
        List<SearchDTO> list = new ArrayList<>();
        try{
            ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
            String encode = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("debug >>> query encode = " + encode);
            URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                    .path("/v1/search/local")
                    .queryParam("query", encode)
                    .queryParam("display", 10)
                    .queryParam("start", 1)
                    .queryParam("sort", "random")
                    .encode().build().toUri();
        System.out.println("debug >> 검색 URL 생성완료");
        //요청 전달 RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity
                                            .get(uri)
                                            .header("X-Naver-Client-Id",client)
                                            .header("X-Naver-Client-Secret",secret)
                                            .build();
        System.out.println("debug >> 요청전달 RestTemplate 생성완료");
        //json 형식의 응답                                    
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        System.out.println("debug >>> json 형식의 응답 완료!!");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.getBody());
        JsonNode items = rootNode.path("items");
        for(JsonNode item : items ){
            System.out.println(item.get("title"));
            SearchDTO dto = new SearchDTO();
            dto.setTitle(item.get("title").asText());
            dto.setAddress(item.get("address").asText());
            dto.setLat(item.get("mapx").asText());
            dto.setLng(item.get("mapy").asText());
            
            dto.setLat(String.valueOf( Double.parseDouble( item.get("mapy").asText() ) / 1e7 ));
            dto.setLng(String.valueOf( Double.parseDouble( item.get("mapx").asText() ) / 1e7 ));

            list.add(dto);
        }
        } catch(Exception e){
            e.printStackTrace();
        }     
        return list;
    }
}