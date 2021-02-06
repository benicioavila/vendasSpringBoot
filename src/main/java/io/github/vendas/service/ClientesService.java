package io.github.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.vendas.domain.entity.Cliente;
import io.github.vendas.repository.ClientesRepository;

@Repository
public class ClientesService {
	
	@Autowired
	private ClientesRepository repository;
	
//	@Autowired
// nas versao atuais do spring se usar construtor posso omitir o autowired
//	public ClientesService(ClientesRepository repository) {
//		this.repository = repository;
//	}
	
	public void salvarCliente(Cliente cliente) {
		this.validarCliente(cliente); 
		repository.persistir(cliente);
	}
	
	public void validarCliente(Cliente cliente) {
		//aplicar validacoes
	}

}
