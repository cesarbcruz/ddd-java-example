package br.com.alura.escola.academico.dominio.aluno.entity;

import br.com.alura.escola.academico.dominio.aluno.exception.RegraNegocioException;
import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import br.com.alura.escola.academico.dominio.aluno.vo.Telefone;
import br.com.alura.escola.shared.domain.vo.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunoAggregate {
	
	private CPF cpf;
	private String nome;
	private Email email;

	private final int NUMERO_MAXIMO_TELEFONE=2;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha;
	
	public AlunoAggregate(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd, String numero) {
		if(telefones.size() == NUMERO_MAXIMO_TELEFONE)
			throw new RegraNegocioException("Numero máximo (" + NUMERO_MAXIMO_TELEFONE + ") de telefones já atingido");
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public CPF getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}


	
}






