package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;
import utils.FileManager;
import utils.Validator;

import static application.Program.input;


public class RegisterPetService {

    String formularyPath = "C:\\javar\\cadastro-pets\\src\\files\\formulario.txt";
    String savePetsPath = "C:\\javar\\cadastro-pets\\src\\files\\petsCadastrados\\";

    public void register() {
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();

        System.out.println(fileManager.fileReader(formularyPath).get(0).toString());
        String name = validator.validatorName(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(2).toString());
        String petType = validator.petTypeValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(4).toString());
        String petSex = validator.petSexValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(6).toString());

        String adress = validator.adressValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(8).toString());
        Double petAge = validator.ageValidator(input.nextLine());


        System.out.println(fileManager.fileReader(formularyPath).get(10).toString());
        Double petWeight = validator.weightValidator(input.nextLine());

        System.out.println(fileManager.fileReader(formularyPath).get(12).toString());
        String petBreed = validator.petBreedValidator(input.nextLine());

        Pet pet = new Pet(name, PetType.valueOf(petType), PetSex.valueOf(petSex), adress, petAge, petWeight, petBreed);
        fileManager.savePet(savePetsPath, pet);
    }
}

