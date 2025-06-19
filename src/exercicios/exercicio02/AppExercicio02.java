package exercicios.exercicio02;

import java.util.Scanner;


public class AppExercicio02 {

    private final Carro carro = new Carro();
    private final Scanner sc = new Scanner(System.in);

    public void init() {
        int opcao;

        do {
            System.out.println("\n=== MENU DO CARRO ===");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Frear");
            System.out.println("5 - Virar para esquerda");
            System.out.println("6 - Virar para direita");
            System.out.println("7 - Trocar marcha");
            System.out.println("8 - Ver status");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> carro.ligar();
                case 2 -> carro.desligar();
                case 3 -> carro.acelerar();
                case 4 -> carro.frear();
                case 5 -> carro.virar("esquerda");
                case 6 -> carro.virar("direita");
                case 7 -> {
                    System.out.print("Informe a nova marcha (0 a 6): ");
                    int novaMarcha = sc.nextInt();
                    carro.trocarMarcha(novaMarcha);
                }
                case 8 -> carro.status();
                case 0 -> System.out.println("Encerrando exercício 2...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}