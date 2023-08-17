package io.github.IgorMontezuma20.vendasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApiApplication {

	@Autowired
	private Environment env;

	@GetMapping("/")
	public String getAmbiente(){
		String ambienteAtual= "PADRÃO (nenhum)";

		if(env.getActiveProfiles().length > 0){
			ambienteAtual = env.getActiveProfiles()[0];
		}

		String appAName = env.getProperty("spring.application.name");

		return String.format("Ambiente: %s | App Name:  %s", ambienteAtual,appAName);
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
