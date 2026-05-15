package Controller;

import model.repository.AlunoRepository;
import model.service.AlunoService;

public class AlunoController {

    private  AlunoRepository repository;
    private  final AlunoService service = new AlunoService();

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }
    public boolean cadastrar(int id, String nome, int matricula) {
        return service.cadastrar(id, nome, matricula, repository);
    }
}