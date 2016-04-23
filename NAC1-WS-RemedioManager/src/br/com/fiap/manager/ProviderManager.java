package br.com.fiap.manager;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.PessoaBO;

public class ProviderManager {
	
	//Cadastrar Pessoa
	public String cadastrarPessoa(long cpf, String nome, int idade, String sexo){
		PessoaBO bo = new PessoaBO();
		try {
			bo.createPessoa(cpf, nome, idade, sexo);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Cadastrado com sucesso!";
		
	}
	
	//Cadastrar Remedio
	
	//Cadastrar Medicacao
	
	//Verificar a proxima medicação a ser tomada
	
	
//	Igor
	
	//Buscar todos os remedios do usuário
	
	//Consultar quantidade de remedios a tomar de acordo com a quantidade de dias

}
