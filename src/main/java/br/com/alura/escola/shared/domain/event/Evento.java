package br.com.alura.escola.shared.domain.event;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {

    LocalDateTime momento();
    TipoEventoEnum tipo();
    Map<String, Object> informacoes();
}
