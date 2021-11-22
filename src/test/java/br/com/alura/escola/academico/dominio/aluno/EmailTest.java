package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.escola.academico.dominio.aluno.vo.Email;
import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Email(null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Email(""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Email("emailinvalido"));
	}

	@Test
	void deveriaPermitirCriarEmailComEnderecoValido() {
		String endereco = "fulano@alura.com.br";
		Email email = new Email(endereco);
		assertEquals(endereco, email.getEndereco());
	}

}
