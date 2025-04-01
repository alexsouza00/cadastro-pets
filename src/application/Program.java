package application;

import entities.Pet;
import services.ListPetsService;
import services.RegisterPetService;
import utils.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Pet> pets = new ArrayList<>();
    public static RegisterPetService registerPetService = new RegisterPetService();
    public static ListPetsService listPetsService = new ListPetsService();
    public static Validator validator = new Validator();

    String formularyPath = "C:\\javar\\cadastro-pets\\src\\files\\formulario.txt";
    String savePetsPath = "C:\\javar\\cadastro-pets\\src\\files\\petsCadastrados\\";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Bem vindo ao programa");
        System.out.println("Pressione enter para continuar ");
        input.nextLine();
        menu();
    }

    public static void menu() throws InterruptedException {

        System.out.println("=============================");
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Cadastrar um novo pet\n" + "2 - Alterar os dados do pet cadastrado\n" + "3 - Deletar um pet cadastrado\n" + "4 - Listar todos os pets cadastrados\n" + "5 - Listar pets por algum critério (idade, nome, raça)\n" + "6 - Sair");

        int option = input.nextInt();
        input.nextLine();
        boolean exit = false;

        while (!exit) {

            switch (option) {
                case 1:
                    registerPetService.register();
                    System.out.println("----Pet cadastrado com sucesso!----");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    listPetsService.listPets();
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                menu();
                break;
                case 5:
                    listPetsService.listPetsWithFilter();
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 6:
                    input.close();
                    exit = true;
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
                    Thread.sleep(3000);
                    System.out.println("");
                    System.out.println("-----------------------------");
            }
        }

    }
}