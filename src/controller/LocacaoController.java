package controller;

import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.repository.AlunoRepository;
import model.repository.EquipamentoRepository;
import model.repository.LocacaoRepository;
import model.service.LocacaoService;

import java.util.HashMap;

public class LocacaoController {

    private LocacaoRepository repository;
    private AlunoRepository alunoRepository;
    private EquipamentoRepository equipamentoRepository;
    private  final LocacaoService service = new LocacaoService();

    public LocacaoController(LocacaoRepository repository, AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public boolean cadastrar(int id, int idAluno, int idEquipamento, String dataLocacao) {
        return service.cadastrar(id, idAluno, idEquipamento, dataLocacao, alunoRepository, equipamentoRepository, repository, Locacao.Status.EM_ANDAMENTO);
    }

    public HashMap<Integer, Aluno> listarAlunos(){
        return alunoRepository.listar();
    }

    public HashMap<Integer, Equipamento> listarEquipamentos(){
        return equipamentoRepository.listar();
    }

    public boolean atualizar(int id, int idAluno, int idEquipamento, String dataLocacao){
        return service.atualizar(id, idAluno, idEquipamento, dataLocacao, Locacao.Status.EM_ANDAMENTO, alunoRepository, equipamentoRepository, repository);
    }

}