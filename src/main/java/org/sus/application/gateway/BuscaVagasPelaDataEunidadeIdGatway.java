package org.sus.application.gateway;

import org.sus.domain.vaga.model.Vaga;

import java.time.LocalDate;
import java.util.List;

public interface BuscaVagasPelaDataEunidadeIdGatway {
    List<Vaga> execute(LocalDate data, Long unidadeId);
}
