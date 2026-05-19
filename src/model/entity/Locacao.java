package model.entity;

public class Locacao {

    private int id;
    private Aluno aluno;
    private Equipamento equipamento;
    private String dataLocacao;
    public enum Status {
        EM_ANDAMENTO,
        FINALIZADO
    }
    
    public Status status;
    
    public Locacao(int id, Aluno aluno, Equipamento equipamento, String dataLocacao, Status status) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", equipamento=" + equipamento +
                ", dataLocacao='" + dataLocacao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
