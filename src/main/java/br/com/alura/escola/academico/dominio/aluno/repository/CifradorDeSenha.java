package br.com.alura.escola.academico.dominio.aluno.repository;

public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	
	boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
