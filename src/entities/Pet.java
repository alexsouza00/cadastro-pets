package entities;

import entities.enums.PetSex;
import entities.enums.PetType;

public class Pet {

    private String name;
    private PetType petType;
    private PetSex petSex;
    private String adress;
    private Double age;
    private Double petWeight;
    private String petBreed;

    public Pet(String name, PetType petType, PetSex petSex, String adress, Double age, Double petWeight, String petBreed) {
        this.name = name;
        this.petType = petType;
        this.petSex = petSex;
        this.adress = adress;
        this.age = age;
        this.petWeight = petWeight;
        this.petBreed = petBreed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetSex getPetSex() {
        return petSex;
    }

    public void setPetSex(PetSex petSex) {
        this.petSex = petSex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Double petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
}
