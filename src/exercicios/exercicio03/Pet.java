package exercicios.exercicio03;

public class Pet {

    private String petName;

    private boolean isCleaned;

    public Pet(String petName){
        this.petName = petName;
        this.isCleaned = false;
    }

    public boolean isCleaned() {
        return isCleaned;
    }

    public void setCleaned(boolean cleaned) {
        isCleaned = cleaned;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
