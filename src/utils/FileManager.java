package utils;

import java.io.*;

public class FileManager {

    String formularyPath = "C:\\javar\\cadastro-pets\\src\\files\\formulario.txt";

    public String formularyRead() {

        StringBuilder formulary = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(formularyPath))) {

            String line = br.readLine();

            while (line != null) {

                formulary.append(line).append("\n");

                line = br.readLine();
            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }

        return formulary.toString();

    }
}
