package utils;

import exceptions.PetRegisterExceptions;

import java.util.Scanner;

import static application.Program.input;

public class Validator {

    public String validatorName(String name) {
        try {
            if (name.equals("")) {
                return name = "NÃO INFORMADO";

            } else if (name.matches(".*\\d.*") == true) {
                throw new PetRegisterExceptions("O nome não pode conter numeros!");
            } else if (name.matches(".*[\\p{P}\\p{S}].*") == true) {
                throw new PetRegisterExceptions("O nome não pode conter caracteres especiais!");
            } else if (name.matches(".*\\s.*") == false) {
                throw new PetRegisterExceptions("Digite um sobrenome!");
            }
            //Verifica se o nome possui caracteres especiais ou numeros, e se possui um sobrenome.
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

            if (!petSex.equalsIgnoreCase("macho") && !petSex.equalsIgnoreCase("femea") ) {
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

    public String adressValidator(String adress) {

        try {
            if (adress.split(",").length < 3) {
                throw new PetRegisterExceptions("Endereço invalido! siga o formato Cidade, rua, casa");
            }

            return adress;
        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return adressValidator(input.nextLine());
        }
    }

    public Double ageValidator(String age) {

        try {
            Double petAge = Double.valueOf(age.replaceAll("[^0-9]", ""));

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
            Double petWeight = Double.valueOf(weight.replaceAll("[^0-9]", ""));

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

            if (petBreed.equals("")) {
                petBreed = "NÃO INFORMADO";
            } else if (petBreed.matches(".*\\d.*") == true || petBreed.matches(".*[\\p{P}\\p{S}].*") == true) {
                throw new PetRegisterExceptions("Raça invalida!");
            }
            return petBreed;

        } catch (PetRegisterExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return petBreedValidator(input.nextLine());
        }
    }

    public int numValidator(String value){

        try{
            if(value.replaceAll("[^0-9]", "") != "[^0-9]" ){
                throw new RuntimeException("Digite um numero!");
            }

            Integer num = Integer.valueOf(value.replaceAll("[^0-9]", ""));

            return num;
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Tente novamente!");
            return numValidator(input.nextLine());
        }
    }
}
