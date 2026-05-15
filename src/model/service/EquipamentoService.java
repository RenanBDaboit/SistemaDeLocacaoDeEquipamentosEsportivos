package model.service;

import model.entity.Equipamento;
import model.repository.EquipamentoRepository;

import java.util.Map;

public class EquipamentoService {

    public boolean cadastrar(int id, String nome, String tipo, EquipamentoRepository repository){

        boolean idDuplicado = false;

        for (Map.Entry<Integer, Equipamento> entry : repository.listar().entrySet()){
            if (entry.getKey() == id){
                idDuplicado = true;
            }
        }

        if (id <= 0 || idDuplicado){
            return false;
        }

        if (nome.isBlank()){
            return false;
        }

        if (tipo.isBlank()){
            return false;
        }

        repository.salvar(new Equipamento(id, nome, tipo));
        return true;
    }
}
