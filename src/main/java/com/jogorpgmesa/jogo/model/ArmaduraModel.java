package com.jogorpgmesa.jogo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_armadura")
public class ArmaduraModel implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @Column(name = "armo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "armo_nome")
    @NotBlank(message = "Armadura deve possuir um nome.")
    private String nome;

    @Column(name = "armo_bonus")
    @NotNull(message = "Armadura deve possuir um bônus na defesa.")
    @Min(1)
    private Integer bonusDefesa;

    @Column(name = "armo_penalidade")
    @NotNull(message = "Armadura deve possuir um nome.")
    @Min(0)
    private Integer penalidadeArmadura;

    @Column(name = "armo_descricao")
    @NotBlank(message = "Armadura deve possuir uma descricao.")
    private String descricao;

    @Column(name = "armo_item_magico")
    @NotNull(message = "A armadura é um item magico (1)? Ou item mundano (0) ?")
    private Boolean itemMagico;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_id_tbl_inventario")
    @Nullable
    private InventarioModel inventarioModelArmadura;

    public ArmaduraModel() {}

    public ArmaduraModel(String nome, Integer bonusDefesa, Integer penalidadeArmadura, String descricao, Boolean itemMagico) {
        this.nome = nome;
        this.bonusDefesa = bonusDefesa;
        this.penalidadeArmadura = penalidadeArmadura;
        this.descricao = descricao;
        this.itemMagico = itemMagico;
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

    public Integer getBonusDefesa() {
        return bonusDefesa;
    }

    public void setBonusDefesa(Integer bonusDefesa) {
        this.bonusDefesa = bonusDefesa;
    }

    public Integer getPenalidadeArmadura() {
        return penalidadeArmadura;
    }

    public void setPenalidadeArmadura(Integer penalidadeArmadura) {
        this.penalidadeArmadura = penalidadeArmadura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getItemMagico() {
        return itemMagico;
    }

    public void setItemMagico(Boolean itemMagico) {
        this.itemMagico = itemMagico;
    }

    @Nullable
    public InventarioModel getInventarioModelArmadura() {
        return inventarioModelArmadura;
    }

    public void setInventarioModelArmadura(@Nullable InventarioModel inventarioModelArmadura) {
        this.inventarioModelArmadura = inventarioModelArmadura;
    }
}
