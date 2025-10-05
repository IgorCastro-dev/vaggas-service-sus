package org.sus.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.sus.application.gateway.*;
import org.sus.application.usecaseimpl.AlocarUsuarioNaVagaImpl;
import org.sus.application.usecaseimpl.ListaTodasAsVagasUseCaseImpl;

@ApplicationScoped
public class VagaConfig {
    @Produces
    @ApplicationScoped
    public ListaTodasAsVagasUseCaseImpl listaTodasAsVagasUseCase(
            ListaVagasGateway listaVagasGateway
    ){
        return new ListaTodasAsVagasUseCaseImpl(listaVagasGateway);
    }

    @Produces
    @ApplicationScoped
    public AlocarUsuarioNaVagaImpl alocarUsuarioNaVagaImpl(
            BuscaUnidadeInfoGateway buscaUnidadeInfoGateway,
            BuscaVagaPorUnidadeIdGateway buscaVagaPorUnidadeIdGateway,
            SalvaVagaGateway salvaVagaGateway,
            EnviaNotificacaoGateway enviaNotificacaoGateway,
            AtualizaVagaGateway atualizaVagaGateway
    ){
        return new AlocarUsuarioNaVagaImpl(
                 buscaUnidadeInfoGateway,
                 buscaVagaPorUnidadeIdGateway,
                 salvaVagaGateway,
                 enviaNotificacaoGateway,
                 atualizaVagaGateway);
    }
}
