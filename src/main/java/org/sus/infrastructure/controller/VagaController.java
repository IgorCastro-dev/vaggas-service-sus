package org.sus.infrastructure.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.sus.domain.vaga.model.Vaga;
import org.sus.domain.vagasinfo.model.VagasInfo;
import org.sus.usecase.ListaHorariosDisponiveisUseCase;
import org.sus.usecase.ListaTodasAsVagasUseCase;

import java.time.LocalDate;
import java.util.List;

@Path("/vaga")
public class VagaController {

    private ListaTodasAsVagasUseCase listaTodasAsVagasUseCase;
    private ListaHorariosDisponiveisUseCase listaHorariosDisponiveisUseCase;

    public VagaController(ListaTodasAsVagasUseCase listaTodasAsVagasUseCase) {
        this.listaTodasAsVagasUseCase = listaTodasAsVagasUseCase;
        this.listaHorariosDisponiveisUseCase = listaHorariosDisponiveisUseCase;
    }

    @GET
    public List<Vaga> getListaVagas() {
        return listaTodasAsVagasUseCase.getListaVagas();
    }

    @GET
    public VagasInfo getListaHorariosDisponiveis(
            @QueryParam("data") LocalDate dataConsulta,
            @QueryParam("id_unidade") Long idUnidade) {
        return listaHorariosDisponiveisUseCase.execute(dataConsulta, idUnidade);
    }
}
