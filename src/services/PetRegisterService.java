package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;
import exceptions.PetRegisterExceptions;
import utils.FileManager;

import static application.Program.input;

public class PetRegisterService {

    public Pet register() {
        while (true) {
            try {
                FileManager fileManager = new FileManager();
                System.out.println(fileManager.formularyRead().get(0).toString());

                String name = input.nextLine();

                if (name.equals("")) {
                    name = "NÃO INFORMADO";

                } else if (name.matches(".*\\d.*") == true) {
                    throw new PetRegisterExceptions("O nome não pode conter numeros!");
                } else if (name.matches(".*[\\p{P}\\p{S}].*") == true) {
                    throw new PetRegisterExceptions("O nome não pode conter caracteres especiais!");
                } else if (name.matches(".*\\s.*") == false) {
                    throw new PetRegisterExceptions("Digite um sobrenome!");
                }
                //Verifica se o nome possui caracteres especiais ou numeros, e se possui um sobrenome.

                System.out.println(fileManager.formularyRead().get(2).toString());
                String petType = input.nextLine();

                if (!petType.equalsIgnoreCase("cachorro") && !petType.equalsIgnoreCase("gato")) {
                    throw new PetRegisterExceptions("Tipo de pet invalido!");
                }

                if (petType.equalsIgnoreCase("cachorro")) {
                    petType = "DOG";
                }
                if (petType.equalsIgnoreCase("gato")) {
                    petType = "CAT";
                }

                System.out.println(fileManager.formularyRead().get(4).toString());
                String petSex = input.nextLine();

                if (!petSex.equalsIgnoreCase("macho") && !petSex.equalsIgnoreCase("femea")) {
                    throw new PetRegisterExceptions("Sexo do pet invalido!(informe macho/femea");
                }

                if (petSex.equalsIgnoreCase("macho")) {
                    petSex = "MALE";
                }
                if (petSex.equalsIgnoreCase("femea")) {
                    petSex = "FEMALE";
                }

                System.out.println(fileManager.formularyRead().get(6).toString());
                System.out.println("Cidade: ");
                String petAdress = "Cidade: " + input.nextLine();
                System.out.println("Rua: ");
                petAdress += ", Rua: " + input.nextLine();
                System.out.println("Numero da casa: ");
                petAdress += ", Casa: " + input.nextLine();

                System.out.println(fileManager.formularyRead().get(8).toString());
                String petAgeString = input.nextLine();
                Double petAge = Double.valueOf(petAgeString.replaceAll("[^0-9]", ""));

                if (petAge <= 0 || petAge > 20) {
                    throw new PetRegisterExceptions("Idade invalida!");
                }

                System.out.println(fileManager.formularyRead().get(10).toString());
                String petWeightString = input.nextLine();
                Double petWeight = Double.valueOf(petWeightString.replaceAll("[^0-9]", ""));
                ;

                if (petWeight < 0.5 || petWeight > 60) {
                    throw new PetRegisterExceptions("Peso invalido!");
                }

                System.out.println(fileManager.formularyRead().get(12).toString());
                String petBreed = input.nextLine();

                if (petBreed.equals("")) {
                    petBreed = "NÃO INFORMADO";
                } else if (petBreed.matches(".*\\d.*") == true || petBreed.matches(".*[\\p{P}\\p{S}].*") == true || petBreed.matches(".*\\s.*") == false) {
                    throw new PetRegisterExceptions("Raça invalida!");
                }

                Pet pet = new Pet(name, PetType.valueOf(petType), PetSex.valueOf(petSex), petAdress, petAge, petWeight, petBreed);
                fileManager.registerPetsInfo(pet);
                return pet;

            } catch (PetRegisterExceptions e) {
                System.out.println(e.getMessage());
                System.out.println("tente novamente: ");
            }

        }
    }
}

