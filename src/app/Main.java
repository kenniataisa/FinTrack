package app;

import java.time.LocalDate;
import java.util.Scanner;
import controller.FinTracker;
import exceptions.EntradaInvalidaException;
import model.Transacao;
import utils.Formatador;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        FinTracker finTracker = new FinTracker();
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenu();
            String opcaoEscolhida = leitor.nextLine();

            switch (opcaoEscolhida) {
                case "1":
                    adicionarNovaTransacao(leitor, finTracker);
                    break;
                case "2":
                    System.out.println("\n===== LISTA DE TRANSACOES =====");
                    finTracker.listarTransacoes();
                    break;
                case "3":
                    double saldoAtual = finTracker.calcularSaldoTotal();
                    System.out.println("\nSaldo atual: " + Formatador.formatarValorMonetario(saldoAtual));
                    break;
                case "4":
                    removerTransacaoExistente(leitor, finTracker);
                    break;
                case "5":
                    continuarExecutando = false;
                    System.out.println("\nEncerrando o FinTrack. Ate logo!");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
                    break;
            }
        }

        leitor.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== FINTRACK - SEU CONTROLE FINANCEIRO =====");
        System.out.println("1. Adicionar nova transacao");
        System.out.println("2. Listar transacoes");
        System.out.println("3. Mostrar saldo atual");
        System.out.println("4. Remover transacao");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void adicionarNovaTransacao(Scanner leitor, FinTracker finTracker) {
        try {
            System.out.print("\nDescricao da transacao: ");
            String descricao = leitor.nextLine();

            System.out.print("Valor da transacao: ");
            double valor = Double.parseDouble(leitor.nextLine());

            System.out.print("Tipo da transacao (1 - Receita / 2 - Despesa): ");
            String tipoEscolhido = leitor.nextLine();
            boolean ehReceita;

            if (tipoEscolhido.equals("1")) {
                ehReceita = true;
            } else if (tipoEscolhido.equals("2")) {
                ehReceita = false;
            } else {
                throw new EntradaInvalidaException("Tipo de transacao invalido.");
            }

            Transacao novaTransacao = new Transacao(descricao, valor, ehReceita, LocalDate.now());
            finTracker.adicionarTransacao(novaTransacao);
            System.out.println("Transacao adicionada com sucesso!");

        } catch (NumberFormatException erro) {
            System.out.println("Erro: o valor informado deve ser numerico.");
        } catch (EntradaInvalidaException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void removerTransacaoExistente(Scanner leitor, FinTracker finTracker) {
        try {
            System.out.println("\n===== LISTA DE TRANSACOES =====");
            finTracker.listarTransacoes();

            if (finTracker.getQuantidadeTransacoes() == 0) {
                return;
            }

            System.out.print("\nDigite o numero da transacao que deseja remover: ");
            int numeroEscolhido = Integer.parseInt(leitor.nextLine());
            int indiceRemocao = numeroEscolhido - 1;

            finTracker.removerTransacao(indiceRemocao);
            System.out.println("Transacao removida com sucesso!");

        } catch (NumberFormatException erro) {
            System.out.println("Erro: digite um numero valido.");
        } catch (EntradaInvalidaException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}