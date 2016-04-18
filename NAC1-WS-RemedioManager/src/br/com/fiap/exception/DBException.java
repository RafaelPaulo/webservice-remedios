package br.com.fiap.exception;

/**
 * Exception lançada pela DAO caso não consiga realizar a operação
 * @author Thiago Yama
 */
public class DBException extends Exception {

	public DBException(String arg0) {
		super(arg0);
	}

}
