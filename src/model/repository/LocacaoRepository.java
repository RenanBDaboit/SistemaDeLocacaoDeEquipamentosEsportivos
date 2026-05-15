package model.repository;

import model.entity.Locacao;
import java.util.HashMap;

public class LocacaoRepository {

    private final HashMap<Integer, Locacao> locacoes = new HashMap<>();

    public void salvar(Locacao locacao) {
        locacoes.put(locacao.getId(), locacao);
    }

    public Locacao buscarPorId(int id) {
        return locacoes.get(id);
    }

    public HashMap<Integer, Locacao> listar() {
        return locacoes;
    }

    public void remover(int id) {
        locacoes.remove(id);
    }
}
