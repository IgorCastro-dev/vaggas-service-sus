package org.sus.usecase;

import org.sus.domain.vagasinfo.model.VagasInfo;

import java.time.LocalDate;

public interface ListaHorariosDisponiveisUseCase {
    VagasInfo execute(LocalDate dataConsulta, Long idUnidade);
}
