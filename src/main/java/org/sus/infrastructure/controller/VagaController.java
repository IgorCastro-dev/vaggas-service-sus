package org.sus.infrastructure.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.sus.application.gateway.ListaVagasGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.usecase.ListaTodasAsVagasUseCase;

import java.util.List;

@Path("/vaga")
public class VagaController {

    private ListaTodasAsVagasUseCase listaTodasAsVagasUseCase;

    public VagaController(ListaTodasAsVagasUseCase listaTodasAsVagasUseCase) {
        this.listaTodasAsVagasUseCase = listaTodasAsVagasUseCase;
    }

    @GET
    public List<Vaga> getListaVagas() {
        return listaTodasAsVagasUseCase.getListaVagas();
    }
}
