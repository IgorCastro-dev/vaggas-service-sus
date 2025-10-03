package org.sus.domain.notificacao.model;

import java.util.Objects;

public class Notificacao {
    private String to;
    private String titulo;
    private String descricao;

    public Notificacao(String s, String titulo, String descricao) {
        to = s;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notificacao that = (Notificacao) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
