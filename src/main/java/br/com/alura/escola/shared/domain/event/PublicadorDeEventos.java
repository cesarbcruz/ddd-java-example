package br.com.alura.escola.shared.domain.event;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {
    private List<Ouvinte> ouvintees = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte){
        this.ouvintees.add(ouvinte);
    }

    public void publicar(Evento evento){
        this.ouvintees.forEach(ouvinte -> ouvinte.processa(evento));
    }
}
