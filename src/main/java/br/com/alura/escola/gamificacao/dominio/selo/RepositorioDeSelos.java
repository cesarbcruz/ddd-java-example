package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.domain.vo.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void adicionar(Selo selo);

    List<Selo> selosDoAlunoDeCPF(CPF cpf);
}
