package teste;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.dao.impl.RemedioDAOImpl;
import br.com.fiap.entity.Remedio;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste2 {
	
	public static void main(String[] args) throws AxisFault {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		RemedioDAO dao = new RemedioDAOImpl(em);
		
		Remedio rem = dao.buscarRemedioNome("Dipirona");
		
		System.out.println(rem.getDescricao());
		
	}
	
}
