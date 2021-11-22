package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.escola.academico.dominio.aluno.event.listener.LogAlunoMatriculado;
import br.com.alura.escola.shared.domain.event.PublicadorDeEventos;
import br.com.alura.escola.shared.domain.vo.CPF;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> Mockito
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		publicadorDeEventos.adicionar(new LogAlunoMatriculado());
		MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);
		
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"Fulano", 
				"123.456.789-00", 
				"fulano@email.com");
		useCase.executa(dados);
		
		AlunoAggregate encontrado = repositorio.buscarPorCPF(
				new CPF("123.456.789-00"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf().getNumero());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}
}
