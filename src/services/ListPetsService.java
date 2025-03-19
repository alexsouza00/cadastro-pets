package services;

import entities.Pet;

import java.util.ArrayList;

public class ListPetsService {


    public void listPets(ArrayList<Pet> pets) {

        for (Pet pet : pets) {

            System.out.println(pet.getName() + " - "
                    + pet.getPetType().getAbout() + " - "
                    + pet.getPetSex().getAbout() + " - "
                    + pet.getAdress() + " - "
                    + Math.round(pet.getAge()) + ((pet.getAge() < 1) ? " anos" : " meses") + " - "
                    + pet.getPetWeight() + " - "
                    + pet.getPetBreed());

        }

    }
}
