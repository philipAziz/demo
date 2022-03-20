package com.example.demo;

import com.example.demo.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class JpayApplication
		//implements CommandLineRunner
{
	@Autowired
	customerService customerService;
	@Autowired
	Environment env;
	public static void main(String[] args) {
		SpringApplication.run(JpayApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		demo1();
//	}
//	private void demo1(){
//		for (com.example.demo.model.customer customer:customerService.findAll()) {
//			System.out.println("id: "+ customer.getId());
//			System.out.println("name: "+ customer.getName());
//			System.out.println("phone: "+ customer.getPhone());
//			System.out.println("+++++++++++++++++++++++++++++");
//		}
//	}

}
