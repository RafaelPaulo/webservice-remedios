package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.entity.Remedio;

public class RemedioDAOImpl extends GenericDAOImpl<Remedio, Integer> implements RemedioDAO{

	public RemedioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Remedio buscarRemedioNome(String nomeRemedio) {
		TypedQuery<Remedio> query = em.createQuery("from Remedio r where r.nome = :n", Remedio.class);
		query.setParameter("n", nomeRemedio);
		return query.getSingleResult();
	}

	@Override
	public List<Remedio> buscarPorPessoa(long cpf) {
		TypedQuery<Remedio>query = em.createQuery("from Remedio r where r.codigo in (select m.remedio.codigo from Medicacao m where m.pessoa.cpf = :c)", Remedio.class);
		query.setParameter("c",cpf);
		return query.getResultList();
	}

	

	
	
	
	

}
