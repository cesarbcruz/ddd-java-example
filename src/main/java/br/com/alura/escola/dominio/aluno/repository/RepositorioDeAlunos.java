package br.com.alura.escola.dominio.aluno.repository;

import br.com.alura.escola.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.dominio.aluno.vo.CPF;

import java.util.List;

public interface RepositorioDeAlunos {
	
	void matricular(AlunoAggregate aluno);
	
	AlunoAggregate buscarPorCPF(CPF cpf);
	
	List<AlunoAggregate> listarTodosAlunosMatriculados();
	
	//...

}
