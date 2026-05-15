package model.repository;

import java.util.HashMap;
import model.entity.Aluno;

public class AlunoRepository {

    private final HashMap<Integer, Aluno> alunos = new HashMap<>();

    public void salvar(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }

    public Aluno buscarPorId(int id) {
        return alunos.get(id);
    }

    public HashMap<Integer, Aluno> listar(){
        return alunos;
    }
    public void remover(int id){
        alunos.remove(id);
    }


}
