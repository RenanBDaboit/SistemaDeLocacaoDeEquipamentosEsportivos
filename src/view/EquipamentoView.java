package view;

import controller.EquipamentoController;
import model.entity.Equipamento;

import java.util.Scanner;

public class EquipamentoView {

    private EquipamentoController controller;

    public void setController(EquipamentoController controller) {
        this.controller = controller;
    }

    private final Scanner scanner = new Scanner(System.in);
    
    public void menuEquipamento(){
        int op;
        do{
            System.out.println("+==============================+");
            System.out.println("|       MENU EQUIPAMENTO       |");
            System.out.println("+==============================+");
            System.out.println("| [1] Cadastrar um equipamento |");
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

        System.out.print("Digite o Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o Tipo: ");
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
