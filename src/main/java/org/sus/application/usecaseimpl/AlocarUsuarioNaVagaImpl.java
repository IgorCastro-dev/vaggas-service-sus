package org.sus.application.usecaseimpl;

import org.sus.application.gateway.*;
import org.sus.domain.agendamentonotificacao.model.AgendamentoNotificacao;
import org.sus.domain.notificacao.model.Notificacao;
import org.sus.domain.unidadeinfo.exception.UnidadeInativaException;
import org.sus.domain.unidadeinfo.model.UnidadeInfo;
import org.sus.domain.vaga.exception.NenhumaVagaDisponivelException;
import org.sus.domain.vaga.model.Vaga;
import org.sus.usecase.AlocarUsuarioNaVagaUseCase;

import java.util.Optional;

public class AlocarUsuarioNaVagaImpl implements AlocarUsuarioNaVagaUseCase {
    private final BuscaUnidadeInfoGateway buscaUnidadeInfoGateway;
    private final BuscaVagaPorUnidadeIdGateway buscaVagaPorUnidadeIdGateway;
    private final SalvaVagaGateway salvaVagaGateway;
    private final EnviaNotificacaoGateway enviaNotificacaoGateway;
    private final AtualizaVagaGateway atualizaVagaGateway;

    public AlocarUsuarioNaVagaImpl(
            BuscaUnidadeInfoGateway buscaUnidadeInfoGateway,
            BuscaVagaPorUnidadeIdGateway buscaVagaPorUnidadeIdGateway,
            SalvaVagaGateway salvaVagaGateway,
            EnviaNotificacaoGateway enviaNotificacaoGateway,
            AtualizaVagaGateway atualizaVagaGateway) {
        this.buscaUnidadeInfoGateway = buscaUnidadeInfoGateway;
        this.buscaVagaPorUnidadeIdGateway = buscaVagaPorUnidadeIdGateway;
        this.salvaVagaGateway = salvaVagaGateway;
        this.enviaNotificacaoGateway = enviaNotificacaoGateway;
        this.atualizaVagaGateway = atualizaVagaGateway;
    }

    @Override
    public void execute(AgendamentoNotificacao agendamentoNotificacao) {
        UnidadeInfo unidadeInfo = buscaUnidadeInfoGateway.buscaUnidadeInfo(agendamentoNotificacao.getUnidadeId());
        if (!unidadeInfo.getAtivo()) {
            throw new UnidadeInativaException("Unidade ID " + agendamentoNotificacao.getUnidadeId() + " está inativa");
        }

        Optional<Vaga> vagaOptional = buscaVagaPorUnidadeIdGateway.execute(agendamentoNotificacao.getUnidadeId());

        Vaga vaga;
        if (vagaOptional.isEmpty()) {
            vaga = new Vaga(unidadeInfo.getCapacidade() - 1, agendamentoNotificacao.getUnidadeId());
            salvaVagaGateway.execute(vaga);
        } else {
            vaga = vagaOptional.get();

            if (vaga.getVagasDisponiveis() <= 0) {
                throw new NenhumaVagaDisponivelException("Não há vagas disponíveis na unidade ID " + agendamentoNotificacao.getUnidadeId());
            }

            vaga.removeCidadaoVaga();
            atualizaVagaGateway.execute(vaga);
        }

        Notificacao notificacao = new Notificacao(
                agendamentoNotificacao.getEmail(),
                "Agendamento",
                "Agendamento Confirmado"
        );
        enviaNotificacaoGateway.execute(notificacao);
    }
}
