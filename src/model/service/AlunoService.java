package model.service;

import model.entity.Aluno;

import java.util.HashMap;
import java.util.Map;

public class AlunoService {

    public boolean cadastrar(int id, String nome, int matricula, HashMap<Integer, Aluno> alunos){

        if (id <= 0){
            return false;
        }

        if (nome.isBlank()){
            return false;
        }

        boolean matriculaDuplicada = false;

        for (Map.Entry<Integer, Aluno> entry : alunos.entrySet()){
            if (matricula == entry.getValue().getMatricula()){
                matriculaDuplicada = true;
            }
        }

        if (matriculaDuplicada){
            return false;
        }

        return true;
    }
}
