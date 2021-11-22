package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.event.listener.LogAlunoMatriculado;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.domain.event.PublicadorDeEventos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
	
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";

		PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
		publicadorDeEventos.adicionar(new LogAlunoMatriculado());
		publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicadorDeEventos);
		matricular.executa(
				new MatricularAlunoDto(nome, 
						cpf, 
						email));
	}

}
