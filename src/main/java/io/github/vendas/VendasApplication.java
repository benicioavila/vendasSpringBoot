package io.github.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.vendas.domain.entity.Cliente;
import io.github.vendas.domain.repository.Clientes;

@SpringBootApplication
//@ComponentScan(
//		basePackages = " io.github.vendas.repository"
//		
//		)
@RestController
public class VendasApplication {

//	@Autowired
//	@Qualifier("applicationName")
//	private String applicationName;
//	
	
	@Value("${application.name}")
	private String applicationName;
	
	
	@GetMapping("/hello")
	public String helloWord() {
		return applicationName;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("Douglas");
			clientes.salvar(cliente);
		};
	}

}
