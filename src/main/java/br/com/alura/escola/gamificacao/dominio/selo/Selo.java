package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.domain.vo.CPF;

public class Selo {
    private CPF cpfDoAluno;
    private String nome;

    public Selo(CPF cpfDoAluno, String nome) {
        this.cpfDoAluno = cpfDoAluno;
        this.nome = nome;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public void setCpfDoAluno(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
