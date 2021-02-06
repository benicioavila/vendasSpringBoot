package io.github.vendas.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.github.vendas.domain.entity.Cliente;

@Repository
public class Clientes {
	
	private static String INSERT = "insert into cliente (nome) values (?) ";
	private static String SELECT_ALL = "SELECT * FROM CLIENTE";
	private static String UPDATE = "update CLIENTE set nome = ? where id = ?";
	
	@Autowired
	private JdbcTemplate jdbTemplate;
	
	public Cliente salvar(Cliente cliente) {
		jdbTemplate.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public List<Cliente> obterTodos(){
		return jdbTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int it) throws SQLException {
				return new Cliente(resultSet.getString("nome"));
			}
		});
	}
	
	public Cliente atualizar(Cliente cliente) {
		return null;
	}

}
