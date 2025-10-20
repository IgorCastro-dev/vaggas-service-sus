package org.sus.infrastructure.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.sus.domain.agendamentonotificacao.model.AgendamentoNotificacao;
import org.sus.usecase.AlocarUsuarioNaVagaUseCase;

@ApplicationScoped
public class KafkaAgendamentoConsumer {
    @Inject
    private AlocarUsuarioNaVagaUseCase alocarUsuarioNaVagaUseCase;

    @Incoming("agendamento-notificacao")
    @Transactional
    public void consumir(AgendamentoNotificacao agendamentoNotificacao) {
        alocarUsuarioNaVagaUseCase.execute(agendamentoNotificacao);
    }
}