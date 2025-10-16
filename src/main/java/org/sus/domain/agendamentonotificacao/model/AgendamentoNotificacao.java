package org.sus.domain.agendamentonotificacao.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AgendamentoNotificacao {
    private String email;
    private Long unidadeId;
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    public AgendamentoNotificacao(String email, Long unidadeId, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
        this.email = email;
        this.unidadeId = unidadeId;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public AgendamentoNotificacao() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
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
        AgendamentoNotificacao that = (AgendamentoNotificacao) o;
        return Objects.equals(email, that.email) && Objects.equals(unidadeId, that.unidadeId) && Objects.equals(data, that.data) && Objects.equals(horarioInicio, that.horarioInicio) && Objects.equals(horarioFim, that.horarioFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, unidadeId, data, horarioInicio, horarioFim);
    }
}
