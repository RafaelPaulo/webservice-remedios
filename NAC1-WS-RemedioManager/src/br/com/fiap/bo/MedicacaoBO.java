package br.com.fiap.bo;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.MedicacaoDAO;
import br.com.fiap.dao.impl.MedicacaoDAOImpl;
import br.com.fiap.entity.Medicacao;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.Remedio;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class MedicacaoBO {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	public void createMedicacao(Calendar dataInicio,Calendar dataTermino, double dosagem, int intervalo, int periodo, long cpf, String nomeRemedio) throws AxisFault, IdNotFoundException{
		
		Medicacao 	 medicacao 	= new Medicacao();
		MedicacaoDAO dao 		= new MedicacaoDAOImpl(em);
		PessoaBO 	 pessoaBo 	= new PessoaBO();
		RemedioBO 	 remedioBo 	= new RemedioBO();
		
		String 		 cpfs 		= Long.toString(cpf);
		
		
		medicacao.setDataInicio(dataInicio);
		medicacao.setDataTermino(dataTermino);
		medicacao.setDosagem(dosagem);
		medicacao.setIntervalo(intervalo);
		medicacao.setPeriodo(periodo);
		
		if(cpfs.length() < 11 || cpfs.length() > 12){
			throw new AxisFault("CPF informado inválido");
		}
		
		Pessoa  p = pessoaBo.readPessoa(cpf);
		Remedio r = remedioBo.readRemedio(nomeRemedio);
		
		medicacao.setPessoa(p);
		medicacao.setRemedio(r);
				
		try {
			dao.cadastrar(medicacao);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Medicacao readMedicacao(String nomeRemedio, String cpf) throws AxisFault{
		MedicacaoDAO dao 		= new MedicacaoDAOImpl(em);
		
		if(cpf.length() < 11 || cpf.length() > 12){
			throw new AxisFault("CPF informado inválido");
		}
		
		long cpfs = Long.parseLong(cpf);
				
		Medicacao medicacao = dao.buscarMedicacaoPorCPFeNomeMedicacao(nomeRemedio, cpfs);
		
		if(medicacao.getCodigo() <= 0){
			throw new AxisFault("Medicação não encontrada");
		}
		
		return medicacao;
	}
	
	

}
