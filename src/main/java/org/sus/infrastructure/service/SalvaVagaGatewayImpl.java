package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.sus.application.gateway.SalvaVagaGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

@ApplicationScoped
public class SalvaVagaGatewayImpl implements SalvaVagaGateway {
    @Inject
    VagaMapper vagaMapper;

    @Inject
    VagaRepository vagaRepository;

    @Override
    @Transactional
    public void execute(Vaga vaga) {
        vagaRepository.persist(vagaMapper.toVagaEntity(vaga));
    }
}
