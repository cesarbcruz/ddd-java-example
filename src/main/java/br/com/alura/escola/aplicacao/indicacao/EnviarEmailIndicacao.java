package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.entity.AlunoAggregate;

public interface EnviarEmailIndicacao {
	
	void enviarPara(AlunoAggregate indicado);

}
