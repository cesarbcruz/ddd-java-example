package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.dominio.aluno.event.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.repository.RepositorioDeAlunos;
import br.com.alura.escola.shared.domain.event.PublicadorDeEventos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	private final PublicadorDeEventos publicadorDeEventos;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicadorDeEventos) {
		this.repositorio = repositorio;
		this.publicadorDeEventos = publicadorDeEventos;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		AlunoAggregate novo = dados.criarAluno();
		repositorio.matricular(novo);
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicadorDeEventos.publicar(evento);
	}

}
