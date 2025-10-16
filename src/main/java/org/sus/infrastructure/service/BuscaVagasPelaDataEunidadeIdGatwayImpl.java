package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.BuscaVagasPelaDataEunidadeIdGatway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.entity.VagaEntity;
import org.sus.infrastructure.mapper.VagaMapper;
import org.sus.infrastructure.repository.VagaRepository;

import java.time.LocalDate;
import java.util.List;


@ApplicationScoped
public class BuscaVagasPelaDataEunidadeIdGatwayImpl implements BuscaVagasPelaDataEunidadeIdGatway {

    @Inject
    VagaRepository vagaRepository;

    @Inject
    VagaMapper vagaMapper;


    @Override
    public List<Vaga> execute(LocalDate data, Long unidadeId) {
        List<VagaEntity> vagaEntityList = vagaRepository.findAllByDataAndUnidadeId(data,unidadeId);
        return vagaEntityList.stream().map(vagaMapper::toVaga).toList();
    }
}
