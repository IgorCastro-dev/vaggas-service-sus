package org.sus.domain.unidadeinfo.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class UnidadeInfo {
    private String nomeUnidade;
    private Boolean ativo;
    private LocalTime horaAbre;
    private LocalTime horaFecha;
    private Duration duracao;

    private UnidadeInfo(String nomeUnidade,Boolean ativo, LocalTime horaAbre, LocalTime horaFecha, Duration duracao) {
        this.nomeUnidade = nomeUnidade;
        this.ativo = ativo;
        this.horaAbre = horaAbre;
        this.horaFecha = horaFecha;
        this.duracao = duracao;
    }

    public static UnidadeInfo criaUnidadeInfo(String nomeUnidade,Boolean ativo, LocalTime horaAbre, LocalTime horaFecha, Duration duracao){
        return new UnidadeInfo(nomeUnidade,ativo, horaAbre,  horaFecha,  duracao);
    }

    public UnidadeInfo() {
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalTime getHoraAbre() {
        return horaAbre;
    }

    public void setHoraAbre(LocalTime horaAbre) {
        this.horaAbre = horaAbre;
    }

    public LocalTime getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(LocalTime horaFecha) {
        this.horaFecha = horaFecha;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeInfo that = (UnidadeInfo) o;
        return Objects.equals(nomeUnidade, that.nomeUnidade) && Objects.equals(ativo, that.ativo) && Objects.equals(horaAbre, that.horaAbre) && Objects.equals(horaFecha, that.horaFecha) && Objects.equals(duracao, that.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeUnidade, ativo, horaAbre, horaFecha, duracao);
    }
}
