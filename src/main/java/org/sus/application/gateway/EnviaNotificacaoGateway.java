package org.sus.application.gateway;

import org.sus.domain.notificacao.model.Notificacao;

public interface EnviaNotificacaoGateway {
    void execute(Notificacao notificacao);
}
