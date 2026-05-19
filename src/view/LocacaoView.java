package view;

import controller.LocacaoController;
import model.entity.Aluno;
import model.entity.Equipamento;

import java.util.Map;
import java.util.Scanner;

public class LocacaoView {

    private final Scanner scanner = new Scanner(System.in);

    private LocacaoController controller;

    public void setController(LocacaoController controller) {
        this.controller = controller;
    }

    public void menuEquipamento(){
        int op;
        do{
            System.out.println("+===================================+");
            System.out.println("|            MENU LOCAÇÃO           |");
            System.out.println("+===================================+");
            System.out.println("| [1] Realizar uma locação          |");
            System.out.println("| [2] Listar locação                |");
            System.out.println("| [3] Atualizar uma locação         |");
            System.out.println("| [4] Finalizar/Remover uma locação |");
            System.out.println("| [0] Sair                          |");
            System.out.println("+===================================+");
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

        System.out.println("Digite o ID");
        int id = Integer.parseInt(scanner.nextLine());

        listarAlunos();
        System.out.println("Digite o ID do Aluno");
        int idAluno = Integer.parseInt(scanner.nextLine());

        listarEquipamentos();
        System.out.println("Digite  ID do equipamento");
        int idEquipamento = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a data da locação");
        String dataLocacao = scanner.nextLine();

        boolean sucesso = controller.cadastrar(id, idAluno, idEquipamento, dataLocacao);

        if (sucesso){
            System.out.println("Locação cadastrada com sucesso");
        }
        else {
            System.out.println("Erro ao cadastrar a locação");
        }
    }

    public void listarAlunos(){
        for (Map.Entry<Integer, Aluno> entry : controller.listarAlunos().entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public void listarEquipamentos(){
        for (Map.Entry<Integer, Equipamento> entry : controller.listarEquipamentos().entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
