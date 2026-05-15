package model.service;

import model.entity.Aluno;
import model.repository.AlunoRepository;

import java.util.Map;

public class AlunoService {

    public boolean cadastrar(int id, String nome, int matricula, AlunoRepository repository){


        boolean idDuplicado = false;

        for (Map.Entry<Integer, Aluno> entry : repository.listar().entrySet()){
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

        boolean matriculaDuplicada = false;

        for (Map.Entry<Integer, Aluno> entry : repository.listar().entrySet()){
            if (matricula == entry.getValue().getMatricula()){
                matriculaDuplicada = true;
            }
        }

        if (matriculaDuplicada){
            return false;
        }

        repository.salvar(new Aluno(id, nome, matricula));
        return true;
    }
}
