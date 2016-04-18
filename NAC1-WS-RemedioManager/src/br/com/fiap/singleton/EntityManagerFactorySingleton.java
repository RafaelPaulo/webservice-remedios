package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * EntityManagerFactorySingleton classe para gerenciar
 * a única instância de EntityManagerFactory
 * @author Rafael Paulo da Silva  Queiroz
 */
public class EntityManagerFactorySingleton {

	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton(){}
	
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return factory;
	}
	
}
