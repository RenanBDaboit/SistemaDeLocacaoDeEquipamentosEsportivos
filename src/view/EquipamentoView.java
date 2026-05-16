package view;

import Controller.EquipamentoController;

import java.util.Scanner;

public class EquipamentoView {

    private EquipamentoController controller;

    public void setController(EquipamentoController controller) {
        this.controller = controller;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrar(){

        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o Tipo: ");
        String tipo = scanner.nextLine();

        boolean sucesso = controller.cadastrar(id, nome, tipo);

        if(sucesso){
            System.out.println("Equipamento cadastrado com sucesso");
        }
        else{
            System.out.println("Erro ao cadastrar equipamento");
        }

    }


}
