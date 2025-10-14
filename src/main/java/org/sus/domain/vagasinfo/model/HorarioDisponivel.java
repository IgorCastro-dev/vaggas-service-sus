package org.sus.domain.vagasinfo.model;

import java.time.LocalTime;
import java.util.Objects;

public class HorarioDisponivel {
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public HorarioDisponivel(LocalTime horaInicio, LocalTime horaFim) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
    public HorarioDisponivel() {}

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HorarioDisponivel that = (HorarioDisponivel) o;
        return Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFim, that.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaInicio, horaFim);
    }
}
