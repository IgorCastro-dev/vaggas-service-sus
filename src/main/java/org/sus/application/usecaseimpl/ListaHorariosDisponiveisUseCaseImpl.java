package org.sus.application.usecaseimpl;

import org.sus.application.gateway.BuscaUnidadeInfoGateway;
import org.sus.application.gateway.BuscaVagasPelaDataEunidadeIdGatway;
import org.sus.domain.unidadeinfo.model.UnidadeInfo;
import org.sus.domain.vaga.model.Vaga;
import org.sus.domain.vagasinfo.model.HorarioDisponivel;
import org.sus.domain.vagasinfo.model.VagasInfo;
import org.sus.usecase.ListaHorariosDisponiveisUseCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListaHorariosDisponiveisUseCaseImpl implements ListaHorariosDisponiveisUseCase {
    private final BuscaUnidadeInfoGateway buscaUnidadeInfoGateway;
    private final BuscaVagasPelaDataEunidadeIdGatway  buscaVagasPelaDataEunidadeIdGatway;

    public ListaHorariosDisponiveisUseCaseImpl(BuscaUnidadeInfoGateway buscaUnidadeInfoGateway, BuscaVagasPelaDataEunidadeIdGatway buscaVagasPelaDataEunidadeIdGatway) {
        this.buscaUnidadeInfoGateway = buscaUnidadeInfoGateway;
        this.buscaVagasPelaDataEunidadeIdGatway = buscaVagasPelaDataEunidadeIdGatway;
    }

    @Override
    public VagasInfo execute(LocalDate dataConsulta, Long idUnidade) {
        List<Vaga> vagas = buscaVagasPelaDataEunidadeIdGatway.execute(dataConsulta,idUnidade);
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

        if (!vagas.isEmpty()) {
            Set<LocalTime> horariosOcupados = vagas.stream()
                    .map(Vaga::getHorarioInicio)
                    .collect(Collectors.toSet());

            horariosDisponiveis.removeIf(h -> horariosOcupados.contains(h.getHoraInicio()));
        }
        vagasInfo.setHorariosDisponiveis(horariosDisponiveis);
        return vagasInfo;
    }
}
