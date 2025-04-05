package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;

import static application.Program.*;

public class RegisterPetService {

    public void register() {

        String formularyPath = fileManager.formularyPath;

        System.out.println(fileManager.fileReader(formularyPath).get(0));
        String name = validator.validatorName(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(2));
        String petType = validator.petTypeValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(4));
        String petSex = validator.petSexValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(6));
        String address = validator.addressValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(8));
        Double petAge = validator.ageValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(10));
        Double petWeight = validator.weightValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(12));
        String petBreed = validator.petBreedValidator(input.nextLine());

        Pet pet = new Pet(name, PetType.valueOf(petType), PetSex.valueOf(petSex), address, petAge, petWeight, petBreed);
        fileManager.savePet(pet);
    }
}

