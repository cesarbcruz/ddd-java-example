package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.dominio.aluno.vo.CPF;
import br.com.alura.escola.dominio.aluno.vo.Email;

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
