package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.entity.Pessoa;

public class PessoaDAOImpl extends GenericDAOImpl<Pessoa, Integer> implements PessoaDAO{

	public PessoaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
