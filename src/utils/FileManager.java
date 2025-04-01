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

    public void savePet(String savePath, Pet pet) {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("[yyyyMMdd'T'HHmm");
        String dateString = date.format(fmt);

        savePath += dateString + "-" + pet.getName().toUpperCase().replaceAll("\\s+", "") + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(savePath))) {

            bw.write("1 - " + pet.getName() + "\n");
            bw.write("2 - " + pet.getPetType().getAbout() + "\n");
            bw.write("3 - " + pet.getPetSex().getAbout() + "\n");
            bw.write("4 - " + pet.getAdress() + "\n");
            bw.write("5 - " + Math.round(pet.getAge()) + ((pet.getAge() < 1) ? "meses" : " anos") + "\n");
            bw.write("6 - " + pet.getPetWeight() + " Kg" + "\n");
            bw.write("7 - " + pet.getPetBreed() + "\n");

        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }
    }

}
