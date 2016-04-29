package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Medicacao;

public interface MedicacaoDAO extends GenericDAO<Medicacao, Integer>{
	
	public Medicacao buscarMedicacaoPorCPFeNomeMedicacao(String nomeRemedio, long cpf);
	
	public List<Medicacao> buscarListaMedicacaoPorCPF(long cpf);

}
