package br.com.alura.escola.dominio.commons.event;

public abstract class Ouvinte {

    public void processa(Evento evento) {
        if(this.deveProcessar(evento)){
            this.reagirAo(evento);
        }
    }

    protected abstract void reagirAo(Evento evento);
    protected abstract boolean deveProcessar(Evento evento);

}
