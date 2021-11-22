package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.academico.dominio.aluno.entity.AlunoAggregate;
import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import br.com.alura.escola.academico.dominio.aluno.exception.RegraNegocioException;
import br.com.alura.escola.shared.domain.vo.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TelefoneAlunoTest {

	@Test
	void naoDeveriaIncluirMaisQueDoisTelefonesParaMesmoAluno() {
		AlunoAggregate aluno = new AlunoAggregate( new CPF("548.192.370-04"),"Cesar Cruz", new Email("cesarcruz@alura.com.br"));
		aluno.adicionarTelefone("19", "999455945");
		aluno.adicionarTelefone("19", "888455948");
		assertEquals(2, aluno.getTelefones().size());
		assertThrows(RegraNegocioException.class,
				() -> aluno.adicionarTelefone("19", "777455647"));
	}

}
