package org.sus.domain.agendamentonotificacao.model;

import java.util.Objects;

public class AgendamentoNotificacao {
    private String email;
    private Long unidadeId;

    public AgendamentoNotificacao(String email, Long unidadeId) {
        this.email = email;
        this.unidadeId = unidadeId;
    }

    public AgendamentoNotificacao() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoNotificacao that = (AgendamentoNotificacao) o;
        return Objects.equals(email, that.email) && Objects.equals(unidadeId, that.unidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, unidadeId);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }
}
