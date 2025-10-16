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
            BuscaVagasPelaDataEunidadeIdGatway buscaVagasDataEunidadeIdGatway,
            SalvaVagaGateway salvaVagaGateway,
            EnviaNotificacaoGateway enviaNotificacaoGateway,
            AtualizaVagaGateway atualizaVagaGateway
    ){
        return new AlocarUsuarioNaVagaImpl(
                 buscaUnidadeInfoGateway,
                buscaVagasDataEunidadeIdGatway,
                 salvaVagaGateway,
                 enviaNotificacaoGateway);
    }
}
