package exercicios.exercicio01;

public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500.0) {
            this.chequeEspecial = 50.0;
        } else {
            this.chequeEspecial = depositoInicial * 0.5;
        }
        this.chequeEspecialUsado = 0.0;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f%n", chequeEspecial);
        System.out.printf("Valor usado do cheque especial: R$ %.2f%n", chequeEspecialUsado);
    }

    public void depositar(double valor) {
        if (chequeEspecialUsado > 0) {
            double taxa = chequeEspecialUsado * 0.2;
            double totalARestituir = chequeEspecialUsado + taxa;

            if (valor >= totalARestituir) {
                valor -= totalARestituir;
                System.out.printf("R$ %.2f usados para quitar cheque especial com taxa de R$ %.2f%n", chequeEspecialUsado, taxa);
                chequeEspecialUsado = 0.0;
            } else {
                double valorAbatido = valor / 1.2;
                chequeEspecialUsado -= valorAbatido;
                System.out.printf("R$ %.2f usados parcialmente para quitar o cheque especial. Novo valor usado: R$ %.2f%n", valor, chequeEspecialUsado);
                return;
            }
        }

        saldo += valor;
        System.out.printf("Depósito realizado. Novo saldo: R$ %.2f%n", saldo);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque realizado. Novo saldo: R$ %.2f%n", saldo);
        } else if (valor <= (saldo + chequeEspecial - chequeEspecialUsado)) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialUsado += restante;
            System.out.printf("Saque realizado utilizando R$ %.2f do cheque especial.%n", restante);
        } else {
            System.out.println("Saldo insuficiente, mesmo com o cheque especial.");
        }
    }

    public void pagarBoleto(double valor) {
        System.out.println("Pagamento de boleto:");
        sacar(valor);
    }

    public void verificarUsoChequeEspecial() {
        if (chequeEspecialUsado > 0) {
            System.out.printf("Você está usando R$ %.2f do cheque especial.%n", chequeEspecialUsado);
        } else {
            System.out.println("Você não está usando o cheque especial.");
        }
    }
}
