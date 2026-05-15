package model.repository;

import model.entity.Equipamento;
import java.util.HashMap;

public class EquipamentoRepository {

    private final HashMap<Integer, Equipamento> equipamentos = new HashMap<>();

    public void salvar(Equipamento equipamento) {
        equipamentos.put(equipamento.getId(), equipamento);
    }
    public Equipamento buscarPorId(int id){
        return equipamentos.get(id);
    }
    public HashMap<Integer, Equipamento> listar(){
        return equipamentos;

    }
    public void remover(int id){
        equipamentos.remove(id);
    }
}
