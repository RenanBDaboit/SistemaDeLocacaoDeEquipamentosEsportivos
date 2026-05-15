package model.service;

import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.repository.LocacaoRepository;

import java.util.Map;

public class LocacaoService {

    public boolean cadastrar(int id, Aluno aluno, Equipamento equipamento, String dataLocacao, LocacaoRepository repository){

        boolean idDuplicado = false;

        for (Map.Entry<Integer, Locacao> entry : repository.listar().entrySet()){
            if (entry.getKey() == id){
                idDuplicado = true;
            }
        }

        if (id <= 0 || idDuplicado){
            return false;
        }

        if (dataLocacao.isBlank()){
            return false;
        }

        repository.salvar(new Locacao(id, aluno, equipamento, dataLocacao));
        return true;
    }
}
