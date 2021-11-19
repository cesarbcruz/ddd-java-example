package br.com.alura.escola.dominio.aluno.event.listener;

import br.com.alura.escola.dominio.aluno.event.AlunoMatriculado;
import br.com.alura.escola.dominio.commons.event.Evento;
import br.com.alura.escola.dominio.commons.event.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogAlunoMatriculado extends Ouvinte {

    public void reagirAo(Evento evento){
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                ((AlunoMatriculado)evento).getCpf().getNumero(),
                evento.momento().format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm"))));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
