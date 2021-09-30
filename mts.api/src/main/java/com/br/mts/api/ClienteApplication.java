package com.br.mts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.br.mts.api.model.entity.Cliente;
import com.br.mts.api.model.entity.Produto;
import com.br.mts.api.model.repository.ClienteRepository;
import com.br.mts.api.model.repository.ProdutoRepository;

// Esta notação diz que esta classe deve iniciar a aplicação, e configura a injeção de dependencia
@SpringBootApplication
public class ClienteApplication {

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository, @Autowired ProdutoRepository repository1) {
		return args ->{
			
			Cliente cliente = Cliente.builder().cpf("08064120977").nome("Luiz de Albuquerque").build();
			repository.save(cliente);
			
			Produto produto = Produto.builder().nome("TESTE").descricao("TESTE2").valor(15L).build();
			repository1.save(produto);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
}
