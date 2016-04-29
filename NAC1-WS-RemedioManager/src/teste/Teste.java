package teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.MedicacaoBO;
import br.com.fiap.bo.PessoaBO;
import br.com.fiap.bo.RemedioBO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.manager.ProviderManager;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) throws IdNotFoundException, AxisFault {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			
		PessoaBO pessoaBo = new PessoaBO();
		RemedioBO remedioBo = new RemedioBO();
		MedicacaoBO medicacaoBo = new MedicacaoBO();
		
		Calendar hoje = Calendar.getInstance();	
		
		String currentTime = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
			
		pessoaBo.createPessoa(45047990818l, "Rafael Paulo", 19, "M");
		remedioBo.createRemedio("Remedio para dores e febre", "Anador", "líquido");
		medicacaoBo.createMedicacao(hoje,hoje,1, 8, 5, 45047990818l, "Anador");
		
		System.out.println("BUSCA");
		ProviderManager pro = new ProviderManager();
		double a = pro.calcularQuantidadeRemediosNecessario("Anador","45047990818");
		System.out.println(a);
		
		em.close();
	}

}
