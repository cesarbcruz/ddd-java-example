package br.com.alura.escola.academico.dominio.indicacao;

import java.time.LocalDateTime;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;

public class Indicacao {

	private AlunoAggregate indicado;
	private AlunoAggregate indicante;
	private LocalDateTime dataIndicacao;

	public Indicacao(AlunoAggregate indicado, AlunoAggregate indicante) {
		this.indicado = indicado;
		this.indicante = indicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public AlunoAggregate getIndicado() {
		return indicado;
	}

	public AlunoAggregate getIndicante() {
		return indicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}

}
