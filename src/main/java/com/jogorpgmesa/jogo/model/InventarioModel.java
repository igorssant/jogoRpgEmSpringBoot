package com.jogorpgmesa.jogo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tbl_inventario")
public class InventarioModel implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @Column(name = "inv_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "jog_id_tbl_jogador")
    private PersonagemModel donoInventario;

    @OneToMany(mappedBy = "inventarioModelArmadura", fetch = FetchType.LAZY)
    private Set<ArmaduraModel> armaduraModelSet = new HashSet<>();

    @OneToMany(mappedBy = "inventarioModelArma", fetch = FetchType.LAZY)
    private Set<ArmaModel> armaModelSet = new HashSet<>();

    public InventarioModel() {}

    public InventarioModel(PersonagemModel donoInventario) {
        this.donoInventario = donoInventario;
    }

    public UUID getId() {
        return id;
    }

    public PersonagemModel getDonoInventario() {
        return donoInventario;
    }

    public void setDonoInventario(PersonagemModel donoInventario) {
        this.donoInventario = donoInventario;
    }

    public Set<ArmaduraModel> getArmaduraModelSet() {
        return armaduraModelSet;
    }

    public void setArmaduraModelSet(Set<ArmaduraModel> armaduraModelSet) {
        this.armaduraModelSet = armaduraModelSet;
    }

    public Set<ArmaModel> getArmaModelSet() {
        return armaModelSet;
    }

    public void setArmaModelSet(Set<ArmaModel> armaModelSet) {
        this.armaModelSet = armaModelSet;
    }
}
