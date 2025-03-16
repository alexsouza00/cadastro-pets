package utils;

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
}
