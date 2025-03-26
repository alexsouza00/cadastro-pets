package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;
import utils.FileManager;
import utils.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListPetsService {
    ArrayList<Pet> pets;


    public void getPetsRegistered() {

        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        File petsFolder = new File(fileManager.savePetsPath);
        File[] files = petsFolder.listFiles();

        try {
            if (files == null) {
                throw new RuntimeException("Sem Pets Cadastrados!");
            }

            this.pets = new ArrayList<>();

            for (File file : files) {

                List<String> petInfo = fileManager.fileReader(file.toString());
                String petName = petInfo.get(0).replaceAll("1 - ", "");
                String petType = validator.petTypeValidator(petInfo.get(1).replaceAll("2 - ", ""));
                String petSex = validator.petSexValidator(petInfo.get(2).replaceAll("3 - ", ""));
                String adress = petInfo.get(3).replaceAll("4 - ", "");
                Double petAge = validator.ageValidator(petInfo.get(4).replaceAll("5 - ", "").replaceAll("anos", ""));
                Double petWeight = validator.weightValidator(petInfo.get(5).replaceAll("6 - ", "").replaceAll("Kg", ""));
                String petBreed = petInfo.get(6).replaceAll("7 - ", "");

                Pet pet = new Pet(petName, PetType.valueOf(petType), PetSex.valueOf(petSex), adress, petAge, petWeight, petBreed);
                this.pets.add(pet);
            }

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void listPets() {
        getPetsRegistered();
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }
    }
}
