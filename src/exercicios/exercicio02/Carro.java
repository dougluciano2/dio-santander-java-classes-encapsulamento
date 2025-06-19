package exercicios.exercicio02;

public class Carro {

    private boolean ligado = false;
    private int marcha = 0; // 0 a 6
    private int velocidade = 0;

    public void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
        } else {
            ligado = true;
            System.out.println("Carro ligado.");
        }
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
        } else if (marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado com sucesso.");
        } else {
            System.out.println("O carro só pode ser desligado em ponto morto e com velocidade 0 km/h.");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("Não é possível acelerar com o carro desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Você precisa estar com uma marcha engatada para acelerar.");
            return;
        }
        if (velocidade < 120) {
            velocidade++;
            System.out.println("Acelerando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("Velocidade máxima atingida!");
        }
        validarMarchaPorVelocidade();
    }

    public void frear() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade > 0) {
            velocidade--;
            System.out.println("Freando... Velocidade atual: " + velocidade + " km/h");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade >= 1 && velocidade <= 40) {
            System.out.println("Virando para " + direcao + "...");
        } else {
            System.out.println("Você só pode virar entre 1 e 40 km/h.");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (Math.abs(novaMarcha - marcha) != 1) {
            System.out.println("Você só pode trocar para marchas adjacentes.");
            return;
        }

        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }

        if (!validarVelocidadeParaMarcha(novaMarcha)) {
            System.out.println("Velocidade atual não permite trocar para essa marcha.");
            return;
        }

        marcha = novaMarcha;
        System.out.println("Marcha atual: " + marcha);
    }

    public void status() {
        System.out.println("=== Status do carro ===");
        System.out.println("Ligado: " + (ligado ? "Sim" : "Não"));
        System.out.println("Marcha: " + marcha);
        System.out.println("Velocidade: " + velocidade + " km/h");
    }

    private boolean validarVelocidadeParaMarcha(int marcha) {
        return switch (marcha) {
            case 0 -> velocidade == 0;
            case 1 -> velocidade >= 0 && velocidade <= 20;
            case 2 -> velocidade >= 21 && velocidade <= 40;
            case 3 -> velocidade >= 41 && velocidade <= 60;
            case 4 -> velocidade >= 61 && velocidade <= 80;
            case 5 -> velocidade >= 81 && velocidade <= 100;
            case 6 -> velocidade >= 101 && velocidade <= 120;
            default -> false;
        };
    }

    private void validarMarchaPorVelocidade() {
        if (!validarVelocidadeParaMarcha(marcha)) {
            System.out.println("A marcha atual não está compatível com a velocidade!");
        }
    }
}
