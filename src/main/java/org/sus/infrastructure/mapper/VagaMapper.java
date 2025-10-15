package org.sus.infrastructure.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.entity.VagaEntity;

@ApplicationScoped
public class VagaMapper {

    public VagaEntity toVagaEntity(Vaga vaga) {
        return new VagaEntity(
                vaga.getId(),
                vaga.getUnidadeId(),
                vaga.getData(),
                vaga.getHorarioInicio(),
                vaga.getHorarioFim()
        );
    }

    public Vaga toVaga(VagaEntity vagaEntity) {
        return new Vaga(
                vagaEntity.getId(),
                vagaEntity.getUnidadeId(),
                vagaEntity.getData(),
                vagaEntity.getHorarioInicio(),
                vagaEntity.getHorarioFim()
        );
    }
}
