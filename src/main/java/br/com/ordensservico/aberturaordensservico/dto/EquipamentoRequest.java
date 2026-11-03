package br.com.ordensservico.aberturaordensservico.dto;

public class EquipamentoRequest {

    private String nome;
    private String numeroPatrimonio;
    private Integer setor;

    public EquipamentoRequest() {
    }

    public Integer getSetor() {
        return setor;
    }

    public void setSetor(Integer setor) {
        this.setor = setor;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}