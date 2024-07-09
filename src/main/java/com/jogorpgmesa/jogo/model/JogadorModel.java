package com.jogorpgmesa.jogo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tbl_jogador")
public class JogadorModel implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @Column(name = "jog_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "jog_nome", nullable = false)
    @NotBlank(message = "Nome não pode ser em branco.")
    private String nome;

    @Column(name = "jog_mestre", nullable = false)
    @NotNull(message = "Informe se o jogador é mestre (1) ou não (0).")
    @Value("false")
    private Boolean mestre;

    @OneToMany(mappedBy = "donoPersonagem", fetch = FetchType.LAZY)
    private Set<PersonagemModel> personagemModelSet = new HashSet<>();

    public JogadorModel() {}

    public JogadorModel(String nome, Boolean mestre) {
        this.nome = nome;
        this.mestre = mestre;
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

    public Boolean getMestre() {
        return mestre;
    }

    public void setMestre(Boolean mestre) {
        this.mestre = mestre;
    }

    public Set<PersonagemModel> getPersonagemModelSet() {
        return personagemModelSet;
    }

    public void setPersonagemModelSet(Set<PersonagemModel> personagemModelSet) {
        this.personagemModelSet = personagemModelSet;
    }
}
