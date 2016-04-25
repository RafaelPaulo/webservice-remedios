package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class PessoaBO {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	public void createPessoa(long cpf, String nome, int idade, String sexo) throws AxisFault{
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		
		sexo = sexo.toUpperCase();
		if(sexo.equals("M") || sexo.equals("MASCULINO")){
			pessoa.setSexo(Sexo.MASCULINO);
		}else if(sexo.equals("F") || sexo.equals("FEMININO")){
			pessoa.setSexo(Sexo.FEMININO);
		}else{
			throw new AxisFault("Sexo inválido");
		}
		
		String cpfs = Float.toString(cpf);
		if(cpfs.length() < 11 || cpfs.length() > 12){
			throw new AxisFault("CPF inválido");
		}
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		try {
			dao.cadastrar(pessoa);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public Pessoa readPessoa(long cpf) throws IdNotFoundException, AxisFault{
		String cpfs = Long.toString(cpf);
		
		if(cpfs.length() < 11 || cpfs.length() > 12){
			throw new AxisFault("CPF informado inválido");
		}
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		return dao.pesquisar(cpf);
	}

}
