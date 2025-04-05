package utils;

import exceptions.PetRegisterExceptions;

import static application.Program.input;

public class Validator {

    public String validatorName(String name) {
        try {
            if (name.isEmpty()) {
                return "NÃO INFORMADO";
            }
            //Verifica se o nome possui caracteres especiais ou numeros, e se possui um sobrenome.
            if (name.matches(".*\\d.*")) {
                throw new PetRegisterExceptions("O nome não pode conter numeros!");
            }
            if (name.matches(".*[\\p{P}\\p{S}].*")) {
                throw new PetRegisterExceptions("O nome não pode conter caracteres especiais!");
            }
            if (!name.matches(".*\\s.*")) {
                throw new PetRegisterExceptions("Digite um sobrenome!");
            }

            return name;
        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return validatorName(input.nextLine());
        }
    }

    public String petTypeValidator(String petType) {

        try {

            if (!petType.equalsIgnoreCase("cachorro") && !petType.equalsIgnoreCase("gato")) {
                throw new PetRegisterExceptions("Tipo de pet invalido! (informe gato/cachorro)");
            }

            if (petType.equalsIgnoreCase("cachorro")) {
                petType = "DOG";
            }

            if (petType.equalsIgnoreCase("gato")) {
                petType = "CAT";
            }

            return petType;

        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return petTypeValidator(input.nextLine());
        }
    }

    public String petSexValidator(String petSex) {

        try {

            if (!petSex.equalsIgnoreCase("macho") && !petSex.equalsIgnoreCase("femea")) {
                throw new PetRegisterExceptions("Sexo do pet invalido!(informe macho/femea)");
            }

            if (petSex.equalsIgnoreCase("macho")) {
                petSex = "MALE";
            }
            if (petSex.equalsIgnoreCase("femea")) {
                petSex = "FEMALE";
            }

            return petSex;

        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return petSexValidator(input.nextLine());
        }
    }

    public String addressValidator(String adress) {

        try {
            if (adress.split(",").length < 3) {
                throw new PetRegisterExceptions("Endereço invalido! siga o formato Cidade, rua, casa");
            }

            return adress;
        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return addressValidator(input.nextLine());
        }
    }

    public Double ageValidator(String age) {

        try {

            age = age.replaceAll("[^0-9]", "");

            if (age.isEmpty()) {
                throw new PetRegisterExceptions("Digite um numero valido!");
            }

            double petAge = Double.parseDouble(age.replaceAll("[^0-9]", ""));

            if (petAge <= 0 || petAge > 20) {
                throw new PetRegisterExceptions("Idade invalida!");
            }

            return petAge;

        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return ageValidator(input.nextLine());
        }
    }

    public Double weightValidator(String weight) {

        try {
            double petWeight = Double.parseDouble(weight.replaceAll("[^0-9]", ""));

            if (petWeight < 0.5 || petWeight > 60) {
                throw new PetRegisterExceptions("Peso invalido!");
            }

            return petWeight;
        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return weightValidator(input.nextLine());
        }

    }

    public String petBreedValidator(String petBreed) {

        try {

            if (petBreed.isEmpty()) {
                petBreed = "NÃO INFORMADO";
            } else if (petBreed.matches(".*\\d.*") || petBreed.matches(".*[\\p{P}\\p{S}].*")) {
                throw new PetRegisterExceptions("Raça invalida!");
            }
            return petBreed;

        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return petBreedValidator(input.nextLine());
        }
    }

    public int numValidator(String value) {

        try {
            if (value.matches("[^0-9]")) {
                throw new RuntimeException("Digite um numero valido!");
            }

            return Integer.parseInt(value.replaceAll("[^0-9]", ""));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return numValidator(input.nextLine());
        }
    }

    public String optionValidator(String option) {
        try {
            if (!option.equalsIgnoreCase("nome")
                    && !option.equalsIgnoreCase("idade")
                    && !option.equalsIgnoreCase("peso")
                    && !option.equalsIgnoreCase("raça")
                    && !option.equalsIgnoreCase("endereço")) {
                throw new PetRegisterExceptions("Informe uma opção válida!");
            }

            return option;
        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return optionValidator(input.nextLine());
        }
    }
}
