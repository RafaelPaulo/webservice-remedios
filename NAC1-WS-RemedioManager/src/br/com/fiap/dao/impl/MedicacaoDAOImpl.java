package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MedicacaoDAO;
import br.com.fiap.entity.Medicacao;

public class MedicacaoDAOImpl extends GenericDAOImpl<Medicacao, Integer> implements MedicacaoDAO{

	public MedicacaoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
