package exercicios.exercicio03;

import java.util.Scanner;

public class AppExercicio03 {

    private final PetBathMachine maquina = new PetBathMachine();
    private final Scanner sc = new Scanner(System.in);

    public void init() {
        int opcao;

        do {
            System.out.println("\n=== MENU PETSHOP ===");
            System.out.println("1 - Colocar pet na máquina");
            System.out.println("2 - Dar banho no pet");
            System.out.println("3 - Retirar pet da máquina");
            System.out.println("4 - Abastecer água (+2L)");
            System.out.println("5 - Abastecer shampoo (+2L)");
            System.out.println("6 - Limpar máquina");
            System.out.println("7 - Verificar níveis");
            System.out.println("8 - Verificar estado da máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    if (maquina.getPetNaMaquina() == null && !maquina.isMachineDirty()) {
                        System.out.print("Digite o nome do pet: ");
                        String nomePet = sc.nextLine();
                        Pet novoPet = new Pet(nomePet);
                        maquina.colocarPet(novoPet);
                    } else {
                        maquina.colocarPet(null);
                    }
                    break;
                case 2:
                    maquina.darBanho();
                    break;
                case 3:
                    maquina.retirarPet();
                    break;
                case 4:
                    maquina.abastecerAgua();
                    break;
                case 5:
                    maquina.abastecerShampoo();
                    break;
                case 6:
                    maquina.limparMaquina();
                    break;
                case 7:
                    maquina.verificarNiveis();
                    break;
                case 8:
                    maquina.verificarEstado();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

    }
}
