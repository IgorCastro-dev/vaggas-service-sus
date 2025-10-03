package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.BuscaVagaPorUnidadeIdGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

import java.util.Optional;

@ApplicationScoped
public class BuscaVagaPorUnidadeIdGatewayImpl implements BuscaVagaPorUnidadeIdGateway {
    @Inject
    VagaRepository vagaRepository;

    @Inject
    VagaMapper vagaMapper;

    @Override
    public Optional<Vaga> execute(Long unidadeId) {
        return vagaRepository.findByUserIdOptional(unidadeId).map(vagaMapper::toVaga);
    }
}
