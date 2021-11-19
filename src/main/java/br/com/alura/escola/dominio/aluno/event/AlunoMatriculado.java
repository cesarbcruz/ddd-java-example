package br.com.alura.escola.dominio.aluno.event;

import br.com.alura.escola.dominio.aluno.vo.CPF;
import br.com.alura.escola.dominio.commons.event.Evento;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final CPF cpf;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpf) {
        this.cpf = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return momento;
    }

    public CPF getCpf() {
        return cpf;
    }
}
