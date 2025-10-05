package org.sus.domain.vaga.model;

import java.util.Objects;

public class Vaga {
    private Long id;
    private Long unidadeId;
    private Integer vagasDisponiveis;

    public Vaga(Long id, Long unidadeId, Integer vagasDisponiveis) {
        this.id = id;
        this.unidadeId = unidadeId;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public Vaga(Integer vagasDisponiveis, Long unidadeId) {
        this.vagasDisponiveis = vagasDisponiveis;
        this.unidadeId = unidadeId;
    }

    public Vaga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public void removeCidadaoVaga(){
        this.vagasDisponiveis--;
    }

    public Integer getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(Integer vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vagas = (Vaga) o;
        return Objects.equals(id, vagas.id) && Objects.equals(unidadeId, vagas.unidadeId) && Objects.equals(vagasDisponiveis, vagas.vagasDisponiveis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unidadeId, vagasDisponiveis);
    }
}
