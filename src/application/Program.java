package application;

import services.ChangePetsInfoService;
import services.DeletePetService;
import services.ListPetsService;
import services.RegisterPetService;
import utils.FileManager;
import utils.Validator;

import java.util.Scanner;

public class Program {
    public static Scanner input = new Scanner(System.in);
    public static RegisterPetService registerPetService = new RegisterPetService();
    public static ListPetsService listPetsService = new ListPetsService();
    public static ChangePetsInfoService changePetsInfoService = new ChangePetsInfoService();
    public static Validator validator = new Validator();
    public static FileManager fileManager = new FileManager();
    public static DeletePetService deletePetService = new DeletePetService();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=====================================");
        System.out.println("Bem vindo ao abrigo Catos e Cachorros");
        System.out.println("Pressione enter para continuar ");
        input.nextLine();
        menu();
        input.close();
    }

    public static void menu() throws InterruptedException {

        System.out.println("=============================");
        System.out.println("Selecione uma opção: ");
        System.out.println("""
                1 - Cadastrar um novo pet
                2 - Alterar os dados do pet cadastrado
                3 - Deletar um pet cadastrado
                4 - Listar todos os pets cadastrados
                5 - Listar pets por algum critério (idade, nome, raça)
                6 - Sair""");

        int option = validator.numValidator(input.nextLine());

        boolean exit = false;

        while (exit == false) {
            switch (option) {
                case 1:
                    System.out.println("");
                    registerPetService.register();
                    System.out.println("----Pet cadastrado com sucesso!----");
                    System.out.println("");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 2:
                    System.out.println("");
                    changePetsInfoService.changeInfos();
                    System.out.println("");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 3:
                    System.out.println("");
                    deletePetService.deletePet();
                    System.out.println("");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 4:
                    System.out.println("");
                    listPetsService.listPets();
                    System.out.println("");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 5:
                    System.out.println("");
                    listPetsService.listPetsWithFilter();
                    System.out.println("");
                    System.out.println("Pressione enter para voltar ao menu");
                    input.nextLine();
                    menu();
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("Até a proxima!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
                    System.out.println("-----------------------------");
                    Thread.sleep(1500);
                    menu();
            }
        }

    }
}