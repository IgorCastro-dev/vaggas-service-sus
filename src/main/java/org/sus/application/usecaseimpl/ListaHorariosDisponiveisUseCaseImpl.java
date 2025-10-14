package org.sus.application.usecaseimpl;

import org.sus.domain.unidadeinfo.model.UnidadeInfo;
import org.sus.domain.vaga.model.Vaga;
import org.sus.domain.vagasinfo.model.HorarioDisponivel;
import org.sus.domain.vagasinfo.model.VagasInfo;
import org.sus.usecase.ListaHorariosDisponiveisUseCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Optional;

public class ListaHorariosDisponiveisUseCaseImpl implements ListaHorariosDisponiveisUseCase {


    @Override
    public VagasInfo execute(LocalDate dataConsulta, Long idUnidade) {
        Optional<Vaga> vaga = buscaVagaPelaData(dataConsulta);
        UnidadeInfo unidadeInfo = buscaUnidadeInfo(idUnidade);

        VagasInfo vagasInfo = new VagasInfo();
        vagasInfo.setUnidadeNome(unidadeInfo.getNomeUnidade());

        LinkedHashSet<HorarioDisponivel> horariosDisponiveis = new LinkedHashSet<>();

        LocalTime horaAtual = unidadeInfo.getHoraAbre();
        while (horaAtual.isBefore(unidadeInfo.getHoraFecha())) {
            LocalTime horaFim = horaAtual.plus(unidadeInfo.getDuracao());
            if (horaFim.isAfter(unidadeInfo.getHoraFecha())) {
                horaFim = unidadeInfo.getHoraFecha();
            }

            HorarioDisponivel horario = new HorarioDisponivel(horaAtual, horaFim);
            horariosDisponiveis.add(horario);
            horaAtual = horaFim;
        }

        if (vaga.isPresent() && vaga.get().getHorarioInicio() != null) {
            vagasInfo.removerHorarioPorInicio(horariosDisponiveis, vaga.get().getHorarioInicio());
        }

        vagasInfo.setHorariosDisponiveis(horariosDisponiveis);
        return vagasInfo;
    }
}
