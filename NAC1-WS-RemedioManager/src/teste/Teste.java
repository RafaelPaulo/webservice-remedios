package teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.dao.impl.RemedioDAOImpl;
import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.Remedio;
import br.com.fiap.entity.Sexo;
import br.com.fiap.entity.TipoRemedio;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		RemedioDAO remedioDao = new RemedioDAOImpl(em);
		PessoaDAO pessoaDao = new PessoaDAOImpl(em);
		
		Pessoa rafael = new Pessoa();
		Remedio dipirona = new Remedio();
		
		rafael.setCpf(45047990818l);
		rafael.setNome("Rafael Paulo");
		rafael.setIdade(19);
		rafael.setSexo(Sexo.MASCULINO);
		
		dipirona.setNome("Dipirona");
		dipirona.setDescricao("Remedio para dores e febre");
		dipirona.setTipo(TipoRemedio.COMPRIMIDO);
		
		try {
			pessoaDao.cadastrar(rafael);
			remedioDao.cadastrar(dipirona);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}

}
