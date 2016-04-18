package br.com.fiap.exception;

/**
 * Exception que será lançada caso o Id não seja encontrado no BD
 * @author Thiago Yama
 */
public class IdNotFoundException extends Exception {

	public IdNotFoundException(String arg) {
		super(arg);
	}
	
}
