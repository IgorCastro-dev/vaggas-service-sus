package org.sus.application.usecaseimpl;

import org.sus.application.gateway.*;
import org.sus.domain.agendamentonotificacao.model.AgendamentoNotificacao;
import org.sus.domain.notificacao.model.Notificacao;
import org.sus.domain.unidadeinfo.exception.UnidadeInativaException;
import org.sus.domain.unidadeinfo.model.UnidadeInfo;
import org.sus.domain.vaga.model.Vaga;
import org.sus.usecase.AlocarUsuarioNaVagaUseCase;

import java.time.Duration;
import java.util.List;

public class AlocarUsuarioNaVagaImpl implements AlocarUsuarioNaVagaUseCase {
    private final BuscaUnidadeInfoGateway buscaUnidadeInfoGateway;
    private final BuscaVagasPelaDataEunidadeIdGatway buscaVagasPelaDataEunidadeIdGatway;
    private final SalvaVagaGateway salvaVagaGateway;
    private final EnviaNotificacaoGateway enviaNotificacaoGateway;

    public AlocarUsuarioNaVagaImpl(
            BuscaUnidadeInfoGateway buscaUnidadeInfoGateway,
            BuscaVagasPelaDataEunidadeIdGatway buscaVagasPelaDataEunidadeIdGatway,
            SalvaVagaGateway salvaVagaGateway,
            EnviaNotificacaoGateway enviaNotificacaoGateway) {
        this.buscaUnidadeInfoGateway = buscaUnidadeInfoGateway;
        this.buscaVagasPelaDataEunidadeIdGatway = buscaVagasPelaDataEunidadeIdGatway;
        this.salvaVagaGateway = salvaVagaGateway;
        this.enviaNotificacaoGateway = enviaNotificacaoGateway;
    }

    @Override
    public void execute(AgendamentoNotificacao agendamentoNotificacao) {
        UnidadeInfo unidadeInfo = buscaUnidadeInfoGateway.execute(agendamentoNotificacao.getUnidadeId());
        if (!unidadeInfo.getAtivo()) {
            throw new UnidadeInativaException("Unidade ID " + agendamentoNotificacao.getUnidadeId() + " está inativa");
        }
        Duration duracaoAgendada = Duration.between(agendamentoNotificacao.getHorarioInicio(), agendamentoNotificacao.getHorarioFim());
        if (!duracaoAgendada.equals(unidadeInfo.getDuracao())) {
            throw new RuntimeException("Range de horários incompatíveis");
        }

        List<Vaga> vagas = buscaVagasPelaDataEunidadeIdGatway.execute(agendamentoNotificacao.getData(), agendamentoNotificacao.getUnidadeId());

        Vaga vaga;
        if (vagas.isEmpty()) {
            vaga = new Vaga(null,
                    agendamentoNotificacao.getUnidadeId(),
                    agendamentoNotificacao.getData(),
                    agendamentoNotificacao.getHorarioInicio(),
                    agendamentoNotificacao.getHorarioFim());
            salvaVagaGateway.execute(vaga);
        } else {
            boolean vagaExistente = vagas.stream()
                    .anyMatch(v -> v.getHorarioInicio().equals(agendamentoNotificacao.getHorarioInicio()));
            if (vagaExistente) {
                throw new RuntimeException("Não há vaga disponível nesse horário");
            }

            vaga = new Vaga(null,
                    agendamentoNotificacao.getUnidadeId(),
                    agendamentoNotificacao.getData(),
                    agendamentoNotificacao.getHorarioInicio(),
                    agendamentoNotificacao.getHorarioFim());
            salvaVagaGateway.execute(vaga);
        }

        Notificacao notificacao = new Notificacao(
                agendamentoNotificacao.getEmail(),
                "Agendamento",
                "Agendamento Confirmado"
        );
        enviaNotificacaoGateway.execute(notificacao);
    }
}
