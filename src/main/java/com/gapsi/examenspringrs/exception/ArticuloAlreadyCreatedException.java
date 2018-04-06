package com.gapsi.examenspringrs.exception;


public class ArticuloAlreadyCreatedException extends RuntimeException {

	private static final long serialVersionUID = 1906002969303089401L;
	
	public ArticuloAlreadyCreatedException(String message) {
		super(message);
	}

}
