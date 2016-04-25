package br.com.fiap.dao;

import br.com.fiap.entity.Remedio;

public interface RemedioDAO extends GenericDAO<Remedio, Integer>{
	
	public Remedio buscarRemedioNome(String nomeRemedio);

}
