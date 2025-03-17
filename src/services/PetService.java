package services;

import entities.Pet;
import entities.enums.PetSex;
import entities.enums.PetType;
import exceptions.PetRegisterExceptions;
import utils.FileManager;

import java.util.regex.PatternSyntaxException;

import static application.Program.input;

public class PetService {

    public Pet register() {
        while (true) {
            try {
                FileManager fileManager = new FileManager();
                System.out.println(fileManager.formularyRead().get(0).toString());

                String name = input.nextLine();

                if (name.equals("")) {
                    name = "NÃO INFORMADO";

                } else if (name.matches(".*\\d.*") == true || name.matches(".*[\\p{P}\\p{S}].*") == true || name.matches(".*\\s.*") == false) {
                    throw new PetRegisterExceptions("Nome invalido!");
                }
                //Verifica se o nome possui caracteres especiais ou numeros, e se possui um sobrenome.

                System.out.println(fileManager.formularyRead().get(2).toString());
                String petType = input.nextLine();

                if (!petType.equals("cachorro") && !petType.equals("gato")) {
                    throw new PetRegisterExceptions("Tipo de pet invalido!");
                }

                if (petType.equals("cachorro")) {
                    petType = "DOG";
                }
                if (petType.equals("gato")) {
                    petType = "CAT";
                }

                System.out.println(fileManager.formularyRead().get(4).toString());
                String petSex = input.nextLine();

                if (!petSex.equals("macho") && !petSex.equals("femea")) {
                    throw new PetRegisterExceptions("Sexo do pet invalido!");
                }

                if (petSex.equals("macho")) {
                    petSex = "MALE";
                }
                if (petSex.equals("femea")) {
                    petSex = "FEMALE";
                }

                System.out.println(fileManager.formularyRead().get(6).toString());
                System.out.println("Numero da casa: ");
                String petAdress = input.nextLine();
                System.out.println("Cidade: ");
                System.out.println("Rua: ");

                System.out.println(fileManager.formularyRead().get(8).toString());
                Double petAge = input.nextDouble();
                input.nextLine();

                if (petAge <= 0 || petAge > 20) {
                    throw new PetRegisterExceptions("Idade invalida!");
                }

                System.out.println(fileManager.formularyRead().get(10).toString());
                Double petWeight = input.nextDouble();
                input.nextLine();

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

                return new Pet(name, PetType.valueOf(petType), PetSex.valueOf(petSex), petAdress, petAge, petWeight, petBreed);

            } catch (PetRegisterExceptions e) {
                System.out.println(e.getMessage());
                System.out.println("tente novamente: ");
            }

        }
    }
}

