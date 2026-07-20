package model;

import java.time.LocalDate;

public class TransacaoMensal extends Transacao {

    private int diaDoMes;

    public TransacaoMensal(String descricao, double valor, boolean ehReceita, LocalDate data, int diaDoMes) {
        super(descricao, valor, ehReceita, data);
        this.diaDoMes = diaDoMes;
    }

    public int getDiaDoMes() {
        return diaDoMes;
    }

    public void setDiaDoMes(int diaDoMes) {
        this.diaDoMes = diaDoMes;
    }

    @Override
    public String toString() {
        return super.toString() + " (Recorrente todo dia " + diaDoMes + ")";
    }
}