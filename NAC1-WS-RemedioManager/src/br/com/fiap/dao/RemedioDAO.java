package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Remedio;

public interface RemedioDAO extends GenericDAO<Remedio, Integer>{
	
	public Remedio buscarRemedioNome(String nomeRemedio);
	
	public List<Remedio> buscarPorPessoa (long cpf);

}
