package com.admin;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.admin.service.FileStorage;
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableWebSecurity
public class AdminPanelApplication   {

	//@jakarta.annotation.Resource
	//FileStorage fileStorage;
	public static void main(String[] args) {
		SpringApplication.run(AdminPanelApplication.class, args);
		
		
	}
//	@Override
//	public void run(String... args) throws Exception {
//		fileStorage.deleteAll();
//		fileStorage.init();
//	}

	
}
