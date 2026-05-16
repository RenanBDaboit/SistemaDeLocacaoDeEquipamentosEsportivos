package view;

import controller.LocacaoController;
import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;

import java.util.Map;
import java.util.Scanner;

public class LocacaoView {

    private final Scanner scanner = new Scanner(System.in);

    private LocacaoController controller;

    public void setController(LocacaoController controller) {
        this.controller = controller;
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
