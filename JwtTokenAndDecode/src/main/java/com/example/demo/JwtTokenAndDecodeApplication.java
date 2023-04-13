package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;

@SpringBootApplication
public class JwtTokenAndDecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenAndDecodeApplication.class, args);
		
		
		
		String secret_key = "J@!gt*K";
		
		//code to test generated token
		String token = JwtUtil.generateToken("Token1", secret_key);
		System.out.println("---------------------Token-------------");
		System.out.println(token);
		System.out.println();
		System.out.println("--------------------Claims----------------");
		
		
		//code to test parsed token :claims
		
		Claims claims = JwtUtil.getClims(token, secret_key);
		
		System.out.println("Token ID: "+claims.getId());
		System.out.println("Token Subject: "+claims.getSubject());
		System.out.println("Token Issuer: "+claims.getIssuer());
		System.out.println("Token Issue Date: "+claims.getIssuedAt());
		System.out.println("Token Expiration Date: "+claims.getExpiration());
		System.out.println("Token Audience: "+claims.getAudience());
	}

}
