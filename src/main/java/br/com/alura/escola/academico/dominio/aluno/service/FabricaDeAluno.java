package br.com.alura.escola.academico.dominio.aluno.service;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import br.com.alura.escola.shared.domain.vo.CPF;

public class FabricaDeAluno {
	
	private AlunoAggregate aluno;

	public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new AlunoAggregate(new CPF(cpf), nome, new Email(email));
		return this;
	}
	
	public FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
	
	public AlunoAggregate criar() {
		return this.aluno;
	}
	
}
