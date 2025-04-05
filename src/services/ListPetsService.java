package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;
import utils.FileManager;
import utils.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static application.Program.input;
import static application.Program.validator;

public class ListPetsService {

    ArrayList<Pet> pets = new ArrayList<>();

    public void getPetsRegistered() {

        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        File petsFolder = new File(fileManager.savePetsPath);
        File[] files = petsFolder.listFiles();

        try {

            if (files.length == 0) {
                throw new RuntimeException("Sem Pets Cadastrados!");
            }

            pets.clear();

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
                pets.add(pet);

            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public void listPets() {

        getPetsRegistered();

        if (!pets.isEmpty()) {
            for (Pet pet : pets) {
                System.out.println(pet.toString());
            }
        }

    }

    public void listPetsWithFilter() {

        getPetsRegistered();
        if (!pets.isEmpty()) {

            try {
                System.out.println("Selecione o tipo de animal(Gato, Cachorro)");
                String petType = validator.petTypeValidator(input.nextLine());

                System.out.println("Selecione os critérios de busca (Nome, Sexo, Idade, Peso, Raça, Endereco): ");
                String filter1 = input.nextLine();

                System.out.println("Digite o valor para o critério: ");
                String filterValue1 = input.nextLine();

                System.out.println("Deseja adicionar um segundo critério? (Sim/Não): ");
                String option = input.nextLine();

                String filter2 = null;
                String filterValue2 = null;

                if (option.equalsIgnoreCase("Sim")) {
                    System.out.println("Selecione o segundo critério de busca: ");
                    filter2 = input.nextLine();
                    System.out.println("Digite o valor para o segundo critério: ");
                    filterValue2 = input.nextLine();
                }

                List<Pet> filteredPets;

                filteredPets = searchPets(petType, filter1, filterValue1, filter2, filterValue2);

                if (filteredPets.isEmpty()) {
                    System.out.println("Nenhum pet encontrado!");
                } else {
                    for (Pet pet : filteredPets) {
                        System.out.println(pet.toString());
                    }
                    filteredPets.clear();
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Pet> searchPets(String petType, String filter1, String filterValue1, String filter2, String filterValue2) {
        return pets.stream().filter(pet -> pet.getPetType().toString().equals(petType))
                .filter(pets -> filterByParameter(pets, filter1, filterValue1))
                .filter(pets -> (filter2 == null || filterByParameter(pets, filter2, filterValue2))).collect(Collectors.toList());
    }

    public boolean filterByParameter(Pet pet, String filter, String filterValue) {
        return switch (filter.toLowerCase()) {
            case "nome" -> pet.getName().toLowerCase().contains(filterValue.toLowerCase());
            case "sexo" -> pet.getPetSex().toString().contains(filterValue);
            case "idade" -> String.valueOf(pet.getAge()).equals(filterValue);
            case "peso" -> String.valueOf(pet.getPetWeight()).equals(filterValue);
            case "raça" -> pet.getPetBreed().toLowerCase().contains(filterValue.toLowerCase());
            case "endereço" -> pet.getAdress().toLowerCase().contains(filterValue.toLowerCase());
            default -> false;
        };
    }

}
