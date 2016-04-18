package br.com.fiap.dao;

import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

/**
 * Inteface que define as funcionalidades 
 * gen�ricas do DAO (CRUD)
 * 
 * @author Rafael Paulo da Silva Queiroz 
 *
 * @param <T> - Classe da Entidade
 * @param <K> - Classe do Tipo da chave prim�ria
 */

public interface GenericDAO<T,K> {

	public void cadastrar(T entidade) throws DBException;
	
	public void alterar(T entidade) throws DBException;
	
	public T pesquisar(K chave) throws IdNotFoundException;
	
	public void excluir(K chave) throws DBException, IdNotFoundException ;
	
}