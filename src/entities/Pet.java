package entities;

import entities.enums.PetSex;
import entities.enums.PetType;

public class Pet {

    private String name;
    private PetType petType;
    private PetSex petSex;
    private String adress;
    private Integer age;
    private Double petWeight;
    private String petBreed;

    public Pet(String name, PetType petType, PetSex petSex, String adress, Integer age, Double petWeight, String petBreed) {
        this.name = name;
        this.petType = petType;
        this.petSex = petSex;
        this.adress = adress;
        this.age = age;
        this.petWeight = petWeight;
        this.petBreed = petBreed;
    }

}
