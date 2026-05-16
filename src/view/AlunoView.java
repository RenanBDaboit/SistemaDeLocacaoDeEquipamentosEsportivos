package view;

import controller.AlunoController;

import java.util.Scanner;

public class AlunoView {

    private AlunoController controller;

    public void setController(AlunoController controller) {
        this.controller = controller;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrar(){

        System.out.println("Digite o ID");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o nome");
        String nome = scanner.nextLine();

        System.out.println("Digite a matrícula");
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
