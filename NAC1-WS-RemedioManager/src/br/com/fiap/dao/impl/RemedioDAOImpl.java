package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.entity.Remedio;

public class RemedioDAOImpl extends GenericDAOImpl<Remedio, Integer> implements RemedioDAO{

	public RemedioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
