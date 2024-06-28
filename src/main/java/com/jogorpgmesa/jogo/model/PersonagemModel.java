package com.jogorpgmesa.jogo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_personagem")
public class PersonagemModel implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @Column(name = "per_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "per_nome", nullable = false)
    @NotBlank(message = "O personagem deve possuir um nome.")
    private String nome;

    @Column(name = "per_idade", nullable = false)
    @NotNull(message = "O personagem deve possuir uma idade.")
    @Min(value = 18, message = "Idade deve ser maior ou igual a 18 anos.")
    private Integer idade;

    @Column(name = "per_sexo", nullable = false)
    @NotNull(message = "Personagem deve possuir um sexo.")
    private Character sexo;

    @Column(name = "per_altura", nullable = false)
    @NotNull(message = "O personagem deve possuir uma idade.")
    @DecimalMin(value = "0.4", message = "Altura deve ser maior ou igual a 0.4 m")
    private Double altura;

    @Column(name = "per_peso", nullable = false)
    @NotNull(message = "O personagem deve possuir um peso.")
    @DecimalMin(value = "1.0", message = "Peso deve ser maior ou igual a 1.0 Kg")
    private Double peso;

    @Column(name = "per_classe", nullable = false)
    @NotNull(message = "O personagem deve possuir uma classe.")
    private Integer classe;

    @Column(name = "per_origem", nullable = false)
    @NotNull(message = "O personagem deve possuir uma origem.")
    private Integer origem;

    @Column(name = "per_deus")
    @Nullable
    private Integer deus;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jog_id_tbl_jogador")
    private JogadorModel donoPersonagem;

    public PersonagemModel() {}

    public PersonagemModel(String nome, Integer idade, Character sexo, Double altura, Double peso, Integer classe, Integer origem, JogadorModel donoPersonagem) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.classe = classe;
        this.origem = origem;
        this.deus = null;
        this.donoPersonagem = donoPersonagem;
    }

    public PersonagemModel(String nome, Integer idade, Character sexo, Double altura, Double peso, Integer classe, Integer origem, Integer deus, JogadorModel donoPersonagem) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.classe = classe;
        this.origem = origem;
        this.deus = deus;
        this.donoPersonagem = donoPersonagem;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getClasse() {
        return classe;
    }

    public void setClasse(Integer classe) {
        this.classe = classe;
    }

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public Integer getDeus() {
        return deus;
    }

    public void setDeus(Integer deus) {
        this.deus = deus;
    }

    public JogadorModel getDonoPersonagem() {
        return donoPersonagem;
    }

    public void setDonoPersonagem(JogadorModel donoPersonagem) {
        this.donoPersonagem = donoPersonagem;
    }
}
