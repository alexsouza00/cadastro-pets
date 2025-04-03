package services;

import entities.Pet;
import utils.FileManager;

import java.util.Locale;

import static application.Program.*;

public class ChangePetsInfoService extends ListPetsService {

    public void changeInfos() {

        try {
            getPetsRegistered();
            if (!pets.isEmpty()) {
                System.out.println("Digite o numero do pet a ser alterado: ");
                int count = 1;

                for (Pet pet : pets) {
                    System.out.println(count + ": " + pet.toString());
                    count++;
                }

                int petOption = input.nextInt();
                input.nextLine();

                System.out.println("Digite o que deseja alterar (Nome, Idade, Peso, Raça, Endereco):");
                String option = input.nextLine();

                fileManager.deletePet(pets.get(petOption - 1).getName());
                changePetInfo(pets.get(petOption - 1), option);
                fileManager.savePet(pets.get(petOption - 1));

            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void changePetInfo(Pet pet, String option) {
        switch (option.toLowerCase(Locale.ROOT)) {
            case "nome":
                System.out.println("Digite o nome:");
                String name = validator.validatorName(input.nextLine());
                pet.setName(name);
                break;

        }
    }
}
