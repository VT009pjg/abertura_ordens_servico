package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "equipamento")
public class Equipamento {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne 
    @JoinColumn (name = "setor_id", referencedColumnName = "id")
    private Setor setor;
    private String nome;
    private String numeroPatrimonio;

    public Equipamento() {
    }

    // Construtor
    public Equipamento(String nome, Setor setor, String numeroPatrimonio) {
        this.nome = nome;
        this.setor = setor;
        this.numeroPatrimonio = numeroPatrimonio;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public int getId() {
        return id;
    }

}
