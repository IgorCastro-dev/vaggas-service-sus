package org.sus.application.usecaseimpl;

import org.sus.application.gateway.BuscaUnidadeInfoGateway;
import org.sus.application.gateway.BuscaVagaPelaDataEunidadeIdGatway;
import org.sus.application.gateway.BuscaVagaPorUnidadeIdGateway;
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
    private final BuscaUnidadeInfoGateway buscaUnidadeInfoGateway;
    private final BuscaVagaPelaDataEunidadeIdGatway  buscaVagaDataEunidadeIdGatway;

    public ListaHorariosDisponiveisUseCaseImpl(BuscaUnidadeInfoGateway buscaUnidadeInfoGateway, BuscaVagaPelaDataEunidadeIdGatway buscaVagaDataEunidadeIdGatway) {
        this.buscaUnidadeInfoGateway = buscaUnidadeInfoGateway;
        this.buscaVagaDataEunidadeIdGatway = buscaVagaDataEunidadeIdGatway;
    }

    @Override
    public VagasInfo execute(LocalDate dataConsulta, Long idUnidade) {
        Optional<Vaga> vaga = buscaVagaDataEunidadeIdGatway.execute(dataConsulta,idUnidade);
        UnidadeInfo unidadeInfo = buscaUnidadeInfoGateway.execute(idUnidade);

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
