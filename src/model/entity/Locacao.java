package model.entity;

public class Locacao {

    private int id;
    private Aluno aluno;
    private Equipamento equipamento;
    private String dataLocacao;
    private String status;

    public Locacao(int id, Aluno aluno, Equipamento equipamento, String dataLocacao, String status) {
        this.id = id;
        this.aluno = aluno;
        this.equipamento = equipamento;
        this.dataLocacao = dataLocacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
