package view;

import controller.AlunoController;

import java.util.Scanner;

public class AlunoView {

    private AlunoController controller;

    public void setController(AlunoController controller) {
        this.controller = controller;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void menuAluno(){
        int op;
        do{
            System.out.println("+==============================+");
            System.out.println("|          MENU ALUNO          |");
            System.out.println("+==============================+");
            System.out.println("| [1] Cadastrar um aluno(a)    |");
            System.out.println("| [0] Sair                     |");
            System.out.println("+==============================+");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(scanner.nextLine());

            switch (op){
                case 1 ->{
                    cadastrar();
                }

                case 0 ->{
                    System.out.println("Saindo...");
                }

                default -> {
                    System.out.println("Opção incorreta!");
                }
            }
        } while (op != 0);

    }

    public void cadastrar(){

        System.out.print("Digite o ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula: ");
        int matricula = Integer.parseInt(scanner.nextLine());

        boolean sucesso = controller.cadastrar(id, nome, matricula);

        if (sucesso){
            System.out.println("Sucesso ao cadastrar Aluno");
        }
        else {
            System.out.println("Erro ao cadastrar aluno");
        }
    }
}
