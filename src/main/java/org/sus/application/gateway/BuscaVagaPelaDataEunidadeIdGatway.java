package org.sus.application.gateway;

import org.sus.domain.vaga.model.Vaga;

import java.time.LocalDate;
import java.util.Optional;

public interface BuscaVagaPelaDataEunidadeIdGatway {
    Optional<Vaga> execute(LocalDate data, Long unidadeId);
}
