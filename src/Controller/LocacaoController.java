package Controller;

import model.entity.Aluno;
import model.entity.Equipamento;
import model.repository.LocacaoRepository;
import model.service.LocacaoService;

public class LocacaoController {

    private LocacaoRepository repository;
    private  final LocacaoService service = new LocacaoService();

    public LocacaoController(LocacaoRepository repository) {
        this.repository = repository;
    }
    public boolean cadastrar(int id, Aluno aluno, Equipamento equipamento, String dataLocacao) {
        return service.cadastrar(id, aluno, equipamento, dataLocacao, repository);
    }
}