package br.com.alura.escola.academico.dominio.aluno.event.listener;

import br.com.alura.escola.shared.domain.event.Ouvinte;
import br.com.alura.escola.academico.dominio.aluno.event.AlunoMatriculado;
import br.com.alura.escola.shared.domain.event.Evento;
import br.com.alura.escola.shared.domain.event.TipoEventoEnum;

import java.time.format.DateTimeFormatter;

public class LogAlunoMatriculado extends Ouvinte {

    public void reagirAo(Evento evento){
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                ((AlunoMatriculado)evento).getCpf().getNumero(),
                evento.momento().format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm"))));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoEventoEnum.ALUNO_MATRICULADO);
    }
}
