package model.service;

import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.repository.AlunoRepository;
import model.repository.EquipamentoRepository;
import model.repository.LocacaoRepository;

import java.util.Map;

public class LocacaoService {

    public boolean cadastrar(int id, int idAluno, int idEquipamento, String dataLocacao, 
                             AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository, 
                             LocacaoRepository repository, Locacao.Status status) {

        boolean idDuplicado = false;

        for (Map.Entry<Integer, Locacao> entry : repository.listar().entrySet()) {
            if (entry.getKey() == id) {
                idDuplicado = true;
            }
        }

        if (id <= 0 || idDuplicado) {
            return false;
        }

        boolean alunoNaoEncontrado = true;
        Aluno aluno = null;

        for (Map.Entry<Integer, Aluno> entry : alunoRepository.listar().entrySet()) {
            if (idAluno == entry.getKey()){
                alunoNaoEncontrado = false;
                aluno = entry.getValue();
            }
        }

        if (alunoNaoEncontrado) {
            return false;
        }

        boolean equipamentoNaoEncontrado = true;
        Equipamento equipamento = null;

        for (Map.Entry<Integer, Equipamento> entry : equipamentoRepository.listar().entrySet()){
            if (idEquipamento == entry.getKey()){
                equipamentoNaoEncontrado = false;
                equipamento = entry.getValue();
            }
        }

        if (equipamentoNaoEncontrado){
            return false;
        }

        if (dataLocacao.isBlank()) {
            return false;
        }

        repository.salvar(new Locacao(id, aluno, equipamento, dataLocacao, Locacao.Status.EM_ANDAMENTO));
        equipamento.setDisponivel(false);
        return true;
    }
    
    public boolean atualizar(int id, int idAluno, int idEquipamento, String dataLocacao, 
                             Locacao.Status status, AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository,
                             LocacaoRepository repository){
        boolean idNaoExistente = true;
        boolean alunoNaoExiste = true;
        boolean equipamentoNaoExiste = true;
        
        Aluno alunoAtualizar = null;
        Equipamento equipamentoAtualizar = null;
        
        if(dataLocacao.isBlank()){
            return false;
        }
        if(status == null){
            return false;
        }

        for (Map.Entry<Integer, Locacao> entry : repository.listar().entrySet()) {
            if (entry.getKey() == id) {
                idNaoExistente = false;
            }
        }

        if (id <= 0 || idNaoExistente) {
            return false;
        }

        boolean alunoNaoEncontrado = true;
        Aluno aluno = null;

        for (Map.Entry<Integer, Aluno> entry : alunoRepository.listar().entrySet()) {
            if (idAluno == entry.getKey()){
                alunoNaoEncontrado = false;
                aluno = entry.getValue();
            }
        }

        if (alunoNaoEncontrado) {
            return false;
        }

        boolean equipamentoNaoEncontrado = true;
        Equipamento equipamento = null;

        for (Map.Entry<Integer, Equipamento> entry : equipamentoRepository.listar().entrySet()){
            if (idEquipamento == entry.getKey()){
                equipamentoNaoEncontrado = false;
                equipamento = entry.getValue();
            }
        }

        if (equipamentoNaoEncontrado){
            return false;
        }

        if (dataLocacao.isBlank()) {
            return false;
        }

        Locacao locacao = repository.buscarPorId(id);

        locacao.getEquipamento().setDisponivel(true);
        
        locacao.setAluno(aluno);
        locacao.setEquipamento(equipamento);
        locacao.setDataLocacao(dataLocacao);
        locacao.setStatus(status);

        repository.salvar(locacao);
        equipamento.setDisponivel(false);
        return true;
    }
}
