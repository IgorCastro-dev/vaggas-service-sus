package org.sus.domain.unidadeinfo.model;

import java.util.Objects;

public class UnidadeInfo {
    private Integer capacidade;
    private Boolean ativo;

    private UnidadeInfo(Integer capacidade, Boolean ativo) {
        this.capacidade = capacidade;
        this.ativo = ativo;
    }

    public static UnidadeInfo criaUnidadeInfo(Integer capacidade, Boolean ativo){
        return new UnidadeInfo(capacidade, ativo);
    }

    public UnidadeInfo() {
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeInfo that = (UnidadeInfo) o;
        return Objects.equals(capacidade, that.capacidade) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacidade, ativo);
    }
}
