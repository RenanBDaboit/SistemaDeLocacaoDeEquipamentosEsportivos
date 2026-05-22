package view;

import controller.AlunoController;

import java.util.Scanner;

public class AlunoView {

    private AlunoController alunoController;

    public AlunoView(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    public void setController(AlunoController alunoController) {
        this.alunoController = alunoController;
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
        int id;
        int matricula;

        System.out.println("Digite o ID");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            id = -1;
        }
        System.out.println("Digite o nome");
        String nome = scanner.nextLine();

        System.out.println("Digite a matrícula");
        try {
            matricula = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            matricula = -1;
        }

        boolean sucesso = alunoController.cadastrar(id, nome, matricula);

        if (sucesso){
            System.out.println("Sucesso ao cadastrar Aluno");
        }
        else {
            System.out.println("Erro ao cadastrar aluno");
        }
    }
}
