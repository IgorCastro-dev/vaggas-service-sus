package org.sus.domain.vaga.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Vaga {
    private Long id;
    private Long unidadeId;
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;


    public Vaga(Long id, Long unidadeId,LocalDate data ,LocalTime horarioInicio, LocalTime horarioFim) {
        this.id = id;
        this.unidadeId = unidadeId;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
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

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Objects.equals(id, vaga.id) && Objects.equals(unidadeId, vaga.unidadeId) && Objects.equals(data, vaga.data) && Objects.equals(horarioInicio, vaga.horarioInicio) && Objects.equals(horarioFim, vaga.horarioFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unidadeId, data, horarioInicio, horarioFim);
    }
}
