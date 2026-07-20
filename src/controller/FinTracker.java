package controller;

import java.util.ArrayList;
import exceptions.EntradaInvalidaException;
import model.Transacao;

public class FinTracker {

    private ArrayList<Transacao> transacoes;

    public FinTracker() {
        this.transacoes = new ArrayList<Transacao>();
    }

    public void adicionarTransacao(Transacao transacao) throws EntradaInvalidaException {
        if (transacao.getDescricao() == null || transacao.getDescricao().trim().isEmpty()) {
            throw new EntradaInvalidaException("A descricao da transacao nao pode ser vazia.");
        }
        if (transacao.getValor() <= 0) {
            throw new EntradaInvalidaException("O valor da transacao deve ser maior que zero.");
        }
        transacoes.add(transacao);
    }

    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transacao cadastrada ate o momento.");
            return;
        }
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println((i + 1) + " - " + transacoes.get(i));
        }
    }

    public void removerTransacao(int indice) throws EntradaInvalidaException {
        if (indice < 0 || indice >= transacoes.size()) {
            throw new EntradaInvalidaException("Indice de transacao invalido.");
        }
        transacoes.remove(indice);
    }

    public double calcularSaldoTotal() {
        double saldoTotal = 0.0;
        for (int i = 0; i < transacoes.size(); i++) {
            Transacao transacaoAtual = transacoes.get(i);
            if (transacaoAtual.isEhReceita()) {
                saldoTotal += transacaoAtual.getValor();
            } else {
                saldoTotal -= transacaoAtual.getValor();
            }
        }
        return saldoTotal;
    }

    public int getQuantidadeTransacoes() {
        return transacoes.size();
    }
}