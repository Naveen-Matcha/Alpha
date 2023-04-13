/*package com.example.demo.feignClients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="address-microservice")
public class AddressMicroserviceLoadBalancerConfig {
	
	@LoadBalanced
	@Bean
	Feign.Builder feignBuilder(){
		return Feign.builder();
	}

}*/
