    import exercicios.exercicio01.AppExercicio01;
    import exercicios.exercicio02.AppExercicio02;
    import exercicios.exercicio03.AppExercicio03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer opcao;

        var exercicio1 = new AppExercicio01();
        var exercicio2 = new AppExercicio02();
        var exercicio3 = new AppExercicio03();



        System.out.println("1 - Exercicio - Conta Bancária");
        System.out.println("2 - Exercicio - Carro");
        System.out.println("3 - Exercicio - PetShop");
        System.out.print("Opção: ");
        opcao = sc.nextInt();

        switch (opcao){
            case 1 -> exercicio1.init();
            case 2 -> exercicio2.init();
            case 3 -> exercicio3.init();
        }


    }
}