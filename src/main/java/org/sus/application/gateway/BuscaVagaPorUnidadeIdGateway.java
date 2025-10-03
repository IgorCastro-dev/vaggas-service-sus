package org.sus.application.gateway;

import org.sus.domain.vaga.model.Vaga;

import java.util.Optional;

public interface BuscaVagaPorUnidadeIdGateway {
    Optional<Vaga> execute(Long unidadeId);
}
