package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.BuscaVagaPelaDataEunidadeIdGatway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class BuscaVagaPelaDataEunidadeIdGatwayImpl implements BuscaVagaPelaDataEunidadeIdGatway {

    @Inject
    VagaRepository vagaRepository;

    @Inject
    VagaMapper vagaMapper;

    @Override
    public Optional<Vaga> execute(LocalDate data, Long unidadeId) {
        return vagaRepository.findByDataAndUnidadeIdOptional(data, unidadeId)
                .map(vagaMapper::toVaga);
    }
}
