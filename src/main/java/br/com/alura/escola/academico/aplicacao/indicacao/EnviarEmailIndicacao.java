package br.com.alura.escola.academico.aplicacao.indicacao;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;

public interface EnviarEmailIndicacao {
	
	void enviarPara(AlunoAggregate indicado);

}
