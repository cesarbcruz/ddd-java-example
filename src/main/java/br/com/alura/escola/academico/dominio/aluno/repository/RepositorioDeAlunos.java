package br.com.alura.escola.academico.dominio.aluno.repository;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.shared.domain.vo.CPF;

import java.util.List;

public interface RepositorioDeAlunos {
	
	void matricular(AlunoAggregate aluno);
	
	AlunoAggregate buscarPorCPF(CPF cpf);
	
	List<AlunoAggregate> listarTodosAlunosMatriculados();
	
	//...

}
