import utils.FileManager;

import java.util.Scanner;

public class Program {
    static Scanner input = new Scanner(System.in);
    static FileManager fileManager = new FileManager();

    public static void main(String[] args) throws InterruptedException {

        menu();

    }

    public static void menu() throws InterruptedException {

        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Cadastrar um novo pet\n" +
                "2 - Alterar os dados do pet cadastrado\n" +
                "3 - Deletar um pet cadastrado\n" +
                "4 - Listar todos os pets cadastrados\n" +
                "5 - Listar pets por algum critério (idade, nome, raça)\n" +
                "6 - Sair");

        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.println(fileManager.formularyRead().toString());
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                input.close();
                break;
            default:
                System.out.println("Selecione uma opção valida!");
                Thread.sleep(3000);
                System.out.println("");
                System.out.println("-----------------------------");
                menu();
        }
    }
}