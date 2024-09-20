package com.jsp.jsp_pjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JspPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspPjtApplication.class, args);
	}

}
