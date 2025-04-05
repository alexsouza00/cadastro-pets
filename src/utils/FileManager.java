package utils;

import entities.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public String savePetsPath = "C:\\000\\cadastro-pets\\src\\files\\petsCadastrados\\";
    public String formularyPath = "C:\\000\\cadastro-pets\\src\\files\\formulario.txt";


    public List<String> fileReader(String filePath) {

        List<String> file = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();

            while (line != null) {

                file.add(line);

                line = br.readLine();

            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }

        return file;
    }

    public void savePet(Pet pet) {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("[yyyyMMdd'T'HHmm");
        String dateString = date.format(fmt);

        savePetsPath += dateString + "-" + pet.getName().toUpperCase().replaceAll("\\s+", "") + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(savePetsPath))) {

            bw.write("1 - " + pet.getName() + "\n");
            bw.write("2 - " + pet.getPetType().getAbout() + "\n");
            bw.write("3 - " + pet.getPetSex().getAbout() + "\n");
            bw.write("4 - " + pet.getAdress() + "\n");
            bw.write("5 - " + Math.round(pet.getAge()) + ((pet.getAge() < 1) ? "meses" : " anos") + "\n");
            bw.write("6 - " + Math.round(pet.getPetWeight()) + " Kg" + "\n");
            bw.write("7 - " + pet.getPetBreed() + "\n");

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }
    }

    public void deletePet(String petName) {

        File petsFolder = new File(savePetsPath);
        File[] files = petsFolder.listFiles();

        for (File file : files) {

            List<String> fileLines = fileReader(file.toString());

            if (fileLines.get(0).contains(petName)) {
                file.delete();

            }


        }

    }
}
