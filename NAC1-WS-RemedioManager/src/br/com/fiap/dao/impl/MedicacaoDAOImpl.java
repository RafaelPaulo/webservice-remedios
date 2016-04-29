package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.MedicacaoDAO;
import br.com.fiap.entity.Medicacao;

public class MedicacaoDAOImpl extends GenericDAOImpl<Medicacao, Integer> implements MedicacaoDAO{

	public MedicacaoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Medicacao buscarMedicacaoPorCPFeNomeMedicacao(String nomeRemedio, long cpf) {
		System.out.println(nomeRemedio + " - " + cpf);
		TypedQuery<Medicacao> query = em.createQuery("from Medicacao m where m.remedio.nome = :r and m.pessoa.cpf = :c", Medicacao.class);
		query.setParameter("r", nomeRemedio);
		query.setParameter("c", cpf);
		return query.getSingleResult();
	}


}
