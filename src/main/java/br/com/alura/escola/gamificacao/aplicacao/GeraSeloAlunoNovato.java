package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.academico.dominio.aluno.event.AlunoMatriculado;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.domain.event.Evento;
import br.com.alura.escola.shared.domain.event.Ouvinte;
import br.com.alura.escola.shared.domain.event.TipoEventoEnum;
import br.com.alura.escola.shared.domain.vo.CPF;

import java.time.format.DateTimeFormatter;

public class GeraSeloAlunoNovato  extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reagirAo(Evento evento) {
        Selo selo = new Selo((CPF) evento.informacoes().get("cpf"), "Novato");
        repositorioDeSelos.adicionar(selo);

        System.out.println(String.format("Selo %s para o CPF %s matriculado em: %s",
                selo.getNome(),
                selo.getCpfDoAluno().getNumero(),
                evento.momento().format(DateTimeFormatter.ofPattern("dd//MM/yyyy HH:mm"))));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoEventoEnum.ALUNO_MATRICULADO);
    }
}
