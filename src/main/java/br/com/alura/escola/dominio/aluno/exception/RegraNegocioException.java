package br.com.alura.escola.dominio.aluno.exception;

import br.com.alura.escola.dominio.aluno.vo.CPF;

public class RegraNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RegraNegocioException(String msg) {
		super(msg);
	}

}
