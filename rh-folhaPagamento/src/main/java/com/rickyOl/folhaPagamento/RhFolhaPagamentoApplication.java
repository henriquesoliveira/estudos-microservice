package com.rickyOl.folhaPagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients 
@SpringBootApplication
public class RhFolhaPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhFolhaPagamentoApplication.class, args);
	}

}
