package utils;

import entities.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    String formularyPath = "C:\\javar\\cadastro-pets\\src\\files\\formulario.txt";

    public List<String> formularyRead() {

        StringBuilder formularyBd = new StringBuilder();
        List<String> formulary = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(formularyPath))) {

            String line = br.readLine();

            while (line != null) {

                formulary.add(line);

                line = br.readLine();

            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }

        return formulary;

    }

    public void registerPetsInfo(Pet pet) {

        String registerPetsPath = "C:\\javar\\cadastro-pets\\src\\files\\petsCadastrados\\" + pet.getName() + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(registerPetsPath))) {


            bw.write("1 - " + pet.getName() + "\n");
            bw.write("2 - " + pet.getPetType() + "\n");
            bw.write("3 - " + pet.getPetSex() + "\n");
            bw.write("4 - " + pet.getAdress() + "\n");
            bw.write("5 - " + pet.getAge() + "\n");
            bw.write("6 - " + pet.getPetWeight() + "\n");
            bw.write("7 - " + pet.getPetBreed() + "\n");
        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }
    }
}
