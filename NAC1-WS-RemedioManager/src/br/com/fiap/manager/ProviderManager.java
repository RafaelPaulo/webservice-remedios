package br.com.fiap.manager;

import java.util.Calendar;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.MedicacaoBO;
import br.com.fiap.bo.PessoaBO;
import br.com.fiap.bo.RemedioBO;
import br.com.fiap.entity.Medicacao;
import br.com.fiap.exception.IdNotFoundException;

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
	public String cadastrarRemedio(String descricao, String nome, String tipo){
		RemedioBO bo = new RemedioBO();
		try {
			bo.createRemedio(descricao, nome, tipo);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Remedio cadastrado com sucesso!";
		
	}
	
	//Cadastrar Medicacao
	public String cadastrarMedicacao(Calendar dataInicio, Calendar dataTermino, double dosagem, int intervalo, int periodo, long cpf, String nomeRemedio) throws IdNotFoundException{
		MedicacaoBO bo = new MedicacaoBO();
		
		try {
			bo.createMedicacao(dataInicio, dataTermino, dosagem, intervalo, periodo, cpf, nomeRemedio);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Medicação cadastrada com sucesso";
	}
	
	
//	Igor
	
	//Buscar todos os remedios do usuário
	
	
	//Calcular quantidade de remedios a ser tomado de acordo com a quantidade de dias
	public double calcularQuantidadeRemediosNecessario(String nomeRemedio, String cpf) throws AxisFault, IdNotFoundException{
		Medicacao m = new MedicacaoBO().readMedicacao(nomeRemedio, cpf);
		
		double totalDeRemedios = ( (24/m.getIntervalo()) * m.getDosagem() ) * m.getPeriodo();
		
		return totalDeRemedios;
	}
}
