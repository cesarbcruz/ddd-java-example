package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import br.com.alura.escola.shared.domain.vo.CPF;

public class MatricularAlunoDto {

	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}

	public AlunoAggregate criarAluno() {
		return new AlunoAggregate(
				new CPF(cpfAluno),
				nomeAluno, 
				new Email(emailAluno));
	}
	
}
