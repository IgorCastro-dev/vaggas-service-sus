package org.sus.infrastructure.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.sus.domain.notificacao.model.Notificacao;

@ApplicationScoped
public class KafkaProducerNotificacao {

    @Inject
    @Channel("notificacao")
    Emitter<Notificacao> emitter;

    public void enviaNotificacao(Notificacao notificacao) {
        emitter.send(notificacao);
    }
}
