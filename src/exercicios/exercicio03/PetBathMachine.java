package exercicios.exercicio03;

public class PetBathMachine {
    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;

    private int waterLevel = 0;
    private int shampooLevel = 0;

    private Pet petNaMaquina = null;
    private boolean machineDirty = false;

    public void abastecerAgua() {
        if (waterLevel + 2 <= MAX_WATER) {
            waterLevel += 2;
            System.out.println("Abastecido com 2L de água. Nível atual: " + waterLevel + "L");
        } else {
            System.out.println("Capacidade máxima de água atingida.");
        }
    }

    public void abastecerShampoo() {
        if (shampooLevel + 2 <= MAX_SHAMPOO) {
            shampooLevel += 2;
            System.out.println("Abastecido com 2L de shampoo. Nível atual: " + shampooLevel + "L");
        } else {
            System.out.println("Capacidade máxima de shampoo atingida.");
        }
    }

    public void colocarPet(Pet pet) {
        if (petNaMaquina != null) {
            System.out.println("Já existe um pet na máquina!");
        } else if (machineDirty) {
            System.out.println("A máquina está suja! Limpe antes de colocar outro pet.");
        } else if (pet == null) {
            System.out.println("Pet inválido.");
        } else {
            petNaMaquina = pet;
            System.out.println("Pet " + pet.getPetName() + " colocado na máquina.");
        }
    }

    public void retirarPet() {
        if (petNaMaquina == null) {
            System.out.println("Não há pet na máquina.");
        } else {
            if (!petNaMaquina.isCleaned()) {
                machineDirty = true;
                System.out.println("Pet " + petNaMaquina.getPetName() + " retirado SUJO. A máquina ficou suja.");
            } else {
                System.out.println("Pet " + petNaMaquina.getPetName() + " retirado LIMPO.");
            }
            petNaMaquina = null;
        }
    }

    public void darBanho() {
        if (petNaMaquina == null) {
            System.out.println("Nenhum pet na máquina para dar banho.");
        } else if (waterLevel < 10 || shampooLevel < 2) {
            System.out.println("Recursos insuficientes para dar banho. Água: " + waterLevel + "L, Shampoo: " + shampooLevel + "L");
        } else {
            waterLevel -= 10;
            shampooLevel -= 2;
            petNaMaquina.setCleaned(true);
            System.out.println("Banho concluído. Pet " + petNaMaquina.getPetName() + " agora está LIMPO.");
        }
    }

    public void limparMaquina() {
        if (!machineDirty) {
            System.out.println("A máquina já está limpa.");
        } else if (waterLevel < 3 || shampooLevel < 1) {
            System.out.println("Recursos insuficientes para limpeza. Água: " + waterLevel + "L, Shampoo: " + shampooLevel + "L");
        } else {
            waterLevel -= 3;
            shampooLevel -= 1;
            machineDirty = false;
            System.out.println("Máquina limpa com sucesso.");
        }
    }

    public void verificarNiveis() {
        System.out.println("Água: " + waterLevel + "L | Shampoo: " + shampooLevel + "L");
    }

    public void verificarEstado() {
        System.out.println("Pet na máquina: " + (petNaMaquina != null ? petNaMaquina.getPetName() : "Nenhum"));
        System.out.println("Máquina está suja: " + (machineDirty ? "Sim" : "Não"));
    }

    public Pet getPetNaMaquina() {
        return petNaMaquina;
    }

    public boolean isMachineDirty() {
        return machineDirty;
    }
}
