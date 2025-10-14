package org.sus.domain.vagasinfo.model;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class VagasInfo {
    private String unidadeNome;
    private LinkedHashSet<HorarioDisponivel> horariosDisponiveis;

    public VagasInfo(String unidadeNome, LinkedHashSet<HorarioDisponivel> horariosDisponiveis) {
        this.unidadeNome = unidadeNome;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public VagasInfo() {
    }

    public String getUnidadeNome() {
        return unidadeNome;
    }

    public void setUnidadeNome(String unidadeNome) {
        this.unidadeNome = unidadeNome;
    }

    public LinkedHashSet<HorarioDisponivel> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(LinkedHashSet<HorarioDisponivel> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public void removerHorarioPorInicio(LinkedHashSet<HorarioDisponivel> horarios, LocalTime horaInicio) {
        horarios.removeIf(horario -> horario.getHoraInicio().equals(horaInicio));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VagasInfo vagasInfo = (VagasInfo) o;
        return Objects.equals(unidadeNome, vagasInfo.unidadeNome) && Objects.equals(horariosDisponiveis, vagasInfo.horariosDisponiveis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unidadeNome, horariosDisponiveis);
    }
}
