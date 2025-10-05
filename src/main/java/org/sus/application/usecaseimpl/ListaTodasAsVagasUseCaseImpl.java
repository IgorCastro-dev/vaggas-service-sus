package org.sus.application.usecaseimpl;

import org.sus.application.gateway.ListaVagasGateway;
import org.sus.domain.vaga.model.Vaga;
import org.sus.usecase.ListaTodasAsVagasUseCase;

import java.util.List;

public class ListaTodasAsVagasUseCaseImpl implements ListaTodasAsVagasUseCase {
    private ListaVagasGateway listaVagasGateway;

    public ListaTodasAsVagasUseCaseImpl(ListaVagasGateway listaVagasGateway) {
        this.listaVagasGateway = listaVagasGateway;
    }

    @Override
    public List<Vaga> getListaVagas() {
        return listaVagasGateway.getListaVagas();
    }

}
