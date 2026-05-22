package view;

import controller.AlunoController;
import controller.EquipamentoController;
import controller.LocacaoController;
import model.repository.AlunoRepository;
import model.repository.EquipamentoRepository;
import model.repository.LocacaoRepository;

import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    private final AlunoRepository alunoRepository = new AlunoRepository();
    private final EquipamentoRepository equipamentoRepository = new EquipamentoRepository();
    private final LocacaoRepository locacaoRepository = new LocacaoRepository();
    
    private final AlunoController alunoController = new AlunoController(alunoRepository);
    private final EquipamentoController equipamentoController = new EquipamentoController(equipamentoRepository);
    private final LocacaoController locacaoController = new LocacaoController(locacaoRepository, alunoRepository, 
            equipamentoRepository);
    
    private final AlunoView alunoView = new AlunoView(alunoController);
    private final EquipamentoView equipamentoView = new EquipamentoView(equipamentoController);
    private final LocacaoView locacaoView = new LocacaoView(locacaoController, locacaoRepository, alunoRepository, equipamentoRepository);
    
    public void menuPrincipal(){
        int op;
        do{
            System.out.println("+=====================================+");
            System.out.println("|            MENU PRINCIPAL           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Alunos                          |");
            System.out.println("| [2] Equipamentos                    |");
            System.out.println("| [3] Locações                        |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op){
                    case 1 -> {
                        alunoView.menuAluno();
                    }

                    case 2 ->{
                        equipamentoView.menuEquipamento();
                    }

                    case 3 ->{
                        locacaoView.menuLocacao();
                    }

                    case 0 ->{
                        System.out.println("Saindo...");
                        break;
                    }

                    default ->{
                        System.out.println("Opção incorreta!");
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Entre com números");
                op = -1;
            }
        } while (op != 0);
    }
}
