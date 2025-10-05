package org.sus.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.sus.domain.vaga.model.Vaga;
import org.sus.infrastructure.entity.VagaEntity;

import java.util.Optional;

@ApplicationScoped
public class VagaRepository implements PanacheRepository<VagaEntity> {
    public Optional<VagaEntity> findByUserIdOptional(Long unidadeId) {
        return find("unidadeId", unidadeId).firstResultOptional();
    }
}
