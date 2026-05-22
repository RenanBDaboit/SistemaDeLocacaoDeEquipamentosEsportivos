package view;

import controller.LocacaoController;
import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.repository.AlunoRepository;
import model.repository.LocacaoRepository;
import model.repository.EquipamentoRepository;

import java.util.Map;
import java.util.Scanner;

public class LocacaoView {

    private final Scanner scanner = new Scanner(System.in);
    private LocacaoController locacaoController;
    private LocacaoRepository locacaoRepository;
    private AlunoRepository alunoRepository;
    private EquipamentoRepository equipamentoRepository;

    public LocacaoView(LocacaoController locacaoController, LocacaoRepository locacaoRepository, 
                       AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository) {
        this.locacaoController = locacaoController;
        this.locacaoRepository = locacaoRepository;
        this.alunoRepository = alunoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public void setController(LocacaoController locacaoController, LocacaoRepository locacaoRepository,
                              AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository) {
        this.locacaoController = locacaoController;
        this.locacaoRepository = locacaoRepository;
        this.alunoRepository = alunoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public void menuLocacao(){
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
            try {
                op = Integer.parseInt(scanner.nextLine());
                switch (op){
                    case 1 ->{
                        cadastrar();
                    }

                    case 2 ->{
                        listarLocacao();
                    }

                    case 3 ->{
                        atualizarLocacao();
                    }

                    case 4 ->{
                        finalizarRemoverLocacao();
                    }

                    case 0 ->{
                        System.out.println("Saindo...");
                    }

                    default -> {
                        System.out.println("Opção incorreta!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entre com um número");
                op = -1;
            }
        } while (op != 0);
    }

    public void cadastrar(){
        int id;
        int idAluno;
        int idEquipamento;

        System.out.println("Digite o ID");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            id = -1;
        }
        listarAlunos();
        System.out.println("Digite o ID do Aluno");
        try {
            idAluno = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            idAluno = -1;
        }

        listarEquipamentos();
        System.out.println("Digite  ID do equipamento");
        try {
            idEquipamento = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            idEquipamento = -1;
        }

        System.out.println("Digite a data da locação");
        String dataLocacao = scanner.nextLine();

        boolean sucesso = locacaoController.cadastrar(id, idAluno, idEquipamento, dataLocacao);

        if (sucesso){
            System.out.println("Locação cadastrada com sucesso");
        }
        else {
            System.out.println("Erro ao cadastrar a locação");
        }
    }

    public void listarAlunos(){
        for (Map.Entry<Integer, Aluno> entry : locacaoController.listarAlunos().entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public void listarEquipamentos(){
        for (Map.Entry<Integer, Equipamento> entry : locacaoController.listarEquipamentos().entrySet()){
            System.out.println(entry.getValue());
        }
    }
    
    public void listarLocacao(){
        for(Locacao locacao : locacaoRepository.listar().values()){
            System.out.println(locacao);
        }
    }
    
    public void atualizarLocacao(){
        int id;
        int idAluno;
        int idEquipamento;

        listarLocacao();
        System.out.print("ID da locação para atualizar: ");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            id = -1;
        }

        listarAlunos();
        System.out.print("Novo aluno: ");
        try {
            idAluno = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            idAluno = -1;
        }

        listarEquipamentos();
        System.out.print("Novo equipamento: ");
        try {
            idEquipamento = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            idEquipamento = -1;
        }

        System.out.print("Nova data de locação (DD/MM/AAAA): ");
        String dataLocacao = scanner.nextLine();

        boolean sucesso = locacaoController.atualizar(id, idAluno, idEquipamento, dataLocacao);

        if (sucesso){
            System.out.println("Locação atualizada com sucesso");
        }
        else {
            System.out.println("Erro ao atualizar a locação");
        }
    }
    
    public void finalizarRemoverLocacao(){
        int id;

        listarLocacao();
        System.out.print("ID da locação para finalizar: ");
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entre com números");
            id = -1;
        }
        Locacao locacao = locacaoRepository.buscarPorId(id);
        
        if(locacao == null){
            System.out.println("Locação não encontrada!");
            return;
        }
        
        locacao.setStatus(Locacao.Status.FINALIZADO);
        
        locacaoRepository.salvar(locacao);
        
        locacaoRepository.remover(id);
        System.out.println("Locação finalizada com sucesso (Status: FINALIZADA)!");
    }
}
