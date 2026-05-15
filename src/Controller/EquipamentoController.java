package Controller;

import model.repository.EquipamentoRepository;
import model.service.EquipamentoService;

public class EquipamentoController {

    private EquipamentoRepository repository;
    private  final EquipamentoService service = new EquipamentoService();

    public EquipamentoController(EquipamentoRepository repository) {
        this.repository = repository;
    }
    public boolean cadastrar(int id, String nome, String tipo) {
        return service.cadastrar(id, nome, tipo, repository);
    }
}