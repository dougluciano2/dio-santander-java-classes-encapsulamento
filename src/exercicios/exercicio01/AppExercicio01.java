package exercicios.exercicio01;

import java.util.Scanner;

public class AppExercicio01 {

    private ContaBancaria conta;
    private final Scanner sc = new Scanner(System.in);

    public void init() {
        System.out.print("Informe o valor de depósito inicial para criar a conta: R$ ");
        double valorInicial = sc.nextDouble();
        conta = new ContaBancaria(valorInicial);

        int opcao;

        do {
            System.out.println("\n=== MENU CONTA BANCÁRIA ===");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso do cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();
                case 2 -> conta.consultarChequeEspecial();
                case 3 -> {
                    System.out.print("Informe o valor a depositar: R$ ");
                    double valor = sc.nextDouble();
                    conta.depositar(valor);
                }
                case 4 -> {
                    System.out.print("Informe o valor a sacar: R$ ");
                    double valor = sc.nextDouble();
                    conta.sacar(valor);
                }
                case 5 -> {
                    System.out.print("Informe o valor do boleto: R$ ");
                    double valor = sc.nextDouble();
                    conta.pagarBoleto(valor);
                }
                case 6 -> conta.verificarUsoChequeEspecial();
                case 0 -> System.out.println("Encerrando exercício 1...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
