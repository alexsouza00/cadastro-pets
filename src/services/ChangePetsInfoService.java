package services;

import entities.Pet;

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

                int petOption = validator.numValidator(input.nextLine());
                if(petOption > pets.size()){
                    throw new RuntimeException("Numero do pet invalido!");
                }

                System.out.println("Digite o que deseja alterar (Nome, Idade, Peso, Raça, Endereco):");
                String option = validator.optionValidator(input.nextLine());

                fileManager.deletePet(pets.get(petOption - 1).getName());
                changePetInfo(pets.get(petOption - 1), option);
                fileManager.savePet(pets.get(petOption - 1));

            }
        } catch (RuntimeException e ) {
            System.out.println(e.getMessage());
            System.out.println("Operação cancelada");
        }
    }

    public void changePetInfo(Pet pet, String option) {
        switch (option.toLowerCase(Locale.ROOT)) {
            case "nome":
                System.out.println("Digite o nome:");
                String name = validator.validatorName(input.nextLine());
                pet.setName(name);
                break;
            case "idade":
                System.out.println("Digite a idade:");
                double age = validator.ageValidator(input.nextLine());
                pet.setAge(age);
                break;
            case "peso":
                System.out.println("Digite o peso: ");
                double weight = validator.weightValidator(input.nextLine());
                pet.setPetWeight(weight);
                break;
            case "raça":
                System.out.println("Digite a raça: ");
                String breed = validator.petBreedValidator(input.nextLine());
                pet.setPetBreed(breed);
                break;
            case "endereço":
                System.out.println("Digite o endereço: ");
                String address = validator.addressValidator(input.nextLine());
                pet.setAdress(address);
                break;
        }
    }
}
