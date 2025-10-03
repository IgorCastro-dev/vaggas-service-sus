package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.AtualizaVagaGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

@ApplicationScoped
public class AtualizaVagaGatewayImpl implements AtualizaVagaGateway {

    @Inject
    VagaMapper vagaMapper;

    @Inject
    VagaRepository vagaRepository;

    @Override
    public void execute(Vaga vaga) {
        vagaRepository.persist(vagaMapper.toVagaEntity(vaga));
    }
}
