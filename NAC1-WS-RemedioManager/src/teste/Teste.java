package teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.MedicacaoBO;
import br.com.fiap.bo.PessoaBO;
import br.com.fiap.bo.RemedioBO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) throws IdNotFoundException {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			
		PessoaBO pessoaBo = new PessoaBO();
		RemedioBO remedioBo = new RemedioBO();
		MedicacaoBO medicacaoBo = new MedicacaoBO();
		
		Calendar hoje = Calendar.getInstance();	
		
		try {
			
			pessoaBo.createPessoa(45047990818l, "Rafael Paulo", 19, "M");
			remedioBo.createRemedio("Remedio para dores e febre", "Anador", "líquido");
			medicacaoBo.createMedicacao(hoje, hoje, 1, 8, 5, 45047990818l, "Anador");
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}

}
