package org.sus.infrastructure.config;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.sus.domain.agendamentonotificacao.model.AgendamentoNotificacao;

public class AgendamentoNotificacaoDeserializer extends ObjectMapperDeserializer<AgendamentoNotificacao> {
    public AgendamentoNotificacaoDeserializer() {
        super(AgendamentoNotificacao.class);
    }
}
