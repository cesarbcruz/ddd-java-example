package br.com.alura.escola.academico.infra.indicacao;

import br.com.alura.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(AlunoAggregate indicado) {
		// logica de envio de email com a lib Java Mail
	}
}
