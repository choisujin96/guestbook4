package com.javaex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Guestbook4Application {

	public static void main(String[] args) { //독립된 프로그램을 만들려고 어디서든 쓸 수 있는 프로그램(개념)을 만들었다.
		SpringApplication.run(Guestbook4Application.class, args);
	}

}
