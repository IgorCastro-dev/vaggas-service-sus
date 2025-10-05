package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.ListaVagasGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

import java.util.List;
@ApplicationScoped
public class ListaVagasGatewayImpl implements ListaVagasGateway {

    @Inject
    VagaRepository vagaRepository;
    @Inject
    VagaMapper vagaMapper;

    public List<Vaga>  getListaVagas() {
        return vagaRepository.findAll().stream().map(vagaMapper :: toVaga).toList();
    }

}
