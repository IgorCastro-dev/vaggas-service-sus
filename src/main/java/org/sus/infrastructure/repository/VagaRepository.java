package org.sus.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.entity.VagaEntity;

import java.util.Optional;

public class VagaRepository implements PanacheRepository<VagaEntity> {
    public Optional<VagaEntity> findByUserIdOptional(Long unidadeId) {
        return find("unidadeId", unidadeId).firstResultOptional();
    }
}
