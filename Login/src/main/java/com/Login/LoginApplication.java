package com.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Login.dao.LoginRepository;
import com.Login.entity.User;

@SpringBootApplication
public class LoginApplication{
	
	@Autowired
	private LoginRepository loginRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		
	
	}
	
}
