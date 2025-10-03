package org.sus.infrastructure.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.sus.application.gateway.EnviaNotificacaoGateway;
import org.sus.domain.notificacao.model.Notificacao;
import org.sus.infrastructure.producer.KafkaProducerNotificacao;

@ApplicationScoped
public class EnviaNotificacaoGatewayImpl implements EnviaNotificacaoGateway {

    @Inject
    KafkaProducerNotificacao kafkaProducerNotificacao;

    @Override
    public void execute(Notificacao notificacao) {
        kafkaProducerNotificacao.enviaNotificacao(notificacao);
    }
}
