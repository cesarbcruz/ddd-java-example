package br.com.alura.escola.academico.dominio.aluno.event;

import br.com.alura.escola.shared.domain.event.Evento;
import br.com.alura.escola.shared.domain.event.TipoEventoEnum;
import br.com.alura.escola.shared.domain.vo.CPF;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public TipoEventoEnum tipo() {
        return TipoEventoEnum.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", this.cpf);
    }

    public CPF getCpf() {
        return cpf;
    }
}
