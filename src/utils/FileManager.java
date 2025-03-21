package utils;

import entities.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileManager {


    public List<String> formularyRead() {
        String formularyPath = "C:\\javar\\cadastro-pets\\src\\files\\formulario.txt";

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

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("[yyyyMMdd'T'HHmm");
        String dateString = date.format(fmt);


        String registerPetsPath = "C:\\javar\\cadastro-pets\\src\\files\\petsCadastrados\\"
                + dateString
                + "-"
                + pet.getName().toUpperCase().replaceAll("\\s+", "")
                + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(registerPetsPath))) {

            bw.write("1 - " + pet.getName() + "\n");
            bw.write("2 - " + pet.getPetType().getAbout() + "\n");
            bw.write("3 - " + pet.getPetSex().getAbout() + "\n");
            bw.write("4 - " + pet.getAdress() + "\n");
            bw.write("5 - " + Math.round(pet.getAge()) + ((pet.getAge() < 1) ? " anos" : " meses") + "\n");
            bw.write("6 - " + pet.getPetWeight() + " Kg" + "\n");
            bw.write("7 - " + pet.getPetBreed() + "\n");

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }
    }
}
