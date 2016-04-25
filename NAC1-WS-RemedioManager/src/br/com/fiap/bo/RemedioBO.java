package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.dao.impl.RemedioDAOImpl;
import br.com.fiap.entity.Remedio;
import br.com.fiap.entity.TipoRemedio;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class RemedioBO {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	public void createRemedio(String descricao, String nome, String tipo) throws AxisFault{
		
		Remedio 	remedio = new Remedio();
		RemedioDAO 	dao 	= new RemedioDAOImpl(em);
		
		remedio.setDescricao(descricao);
		remedio.setNome(nome);
		
		tipo = tipo.replaceAll("ï|î|í","i").toUpperCase();
		
		if(tipo.equals("COMPRIMIDO") || tipo.equals("C")){			
			remedio.setTipo(TipoRemedio.COMPRIMIDO);
		}else if(tipo.equals("LIQUIDO") || tipo.equals("L")){
			remedio.setTipo(TipoRemedio.LIQUIDO);
		}else{
			throw new AxisFault("Tipo de remédio inválido");
		}
		
		
		try {
			dao.cadastrar(remedio);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Remedio readRemedio(String nomeRemedio) throws AxisFault{
		RemedioDAO dao = new RemedioDAOImpl(em);
		Remedio rem = dao.buscarRemedioNome(nomeRemedio);
		
		if(rem == null  || rem.getNome().equals("")){
			throw new AxisFault("Remédio não encontrado");
		}
		
		return rem; 
	}

}
