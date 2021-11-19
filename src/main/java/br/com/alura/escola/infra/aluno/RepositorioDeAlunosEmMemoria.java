package br.com.alura.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.vo.CPF;
import br.com.alura.escola.dominio.aluno.repository.RepositorioDeAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<AlunoAggregate> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(AlunoAggregate aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public AlunoAggregate buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().getNumero().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<AlunoAggregate> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
