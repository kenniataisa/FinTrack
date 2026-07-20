package model;

import java.time.LocalDate;

public class Transacao {

    private String descricao;
    private double valor;
    private boolean ehReceita;
    private LocalDate data;

    public Transacao(String descricao, double valor, boolean ehReceita, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.ehReceita = ehReceita;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEhReceita() {
        return ehReceita;
    }

    public void setEhReceita(boolean ehReceita) {
        this.ehReceita = ehReceita;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipoDescricao() {
        if (ehReceita) {
            return "Receita";
        } else {
            return "Despesa";
        }
    }

    @Override
    public String toString() {
        return "[" + getTipoDescricao() + "] " + descricao + " - R$ "
                + String.format("%.2f", valor) + " - " + data;
    }
}