package services;

import entities.Pet;

import static application.Program.*;

public class DeletePetService extends ListPetsService {


    public void deletePet() {
        try {
            getPetsRegistered();
            if (!pets.isEmpty()) {
                System.out.println("Digite o numero do pet a ser deletado: ");
                int count = 1;

                for (Pet pet : pets) {
                    System.out.println(count + ": " + pet.toString());
                    count++;
                }

                int petOption = validator.numValidator(input.nextLine());
                if (petOption > pets.size()) {
                    throw new RuntimeException("Numero do pet invalido!");
                }

                fileManager.deletePet(pets.get(petOption - 1).getName());
                System.out.println("Pet deletado com sucesso!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Operação cancelada!");
        }
    }
}