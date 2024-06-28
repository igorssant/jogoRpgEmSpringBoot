package com.jogorpgmesa.jogo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tbl_arma")
public class ArmaModel implements Serializable {
    private static final Long serialVersionUID = 3L;

    @Id
    @Column(name = "arm_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "arm_nome", nullable = false)
    @NotBlank(message = "Arma deve possuir um nome.")
    private String nome;

    @Column(name = "arm_dano", nullable = false)
    @NotBlank(message = "Arma deve possuir um dano.")
    private String dano;

    @Column(name = "arm_bonus_ataque", nullable = false)
    @Nullable
    @Value("0")
    private Integer bonusAtaque;

    @Column(name = "arm_bonus_dano", nullable = false)
    @Nullable
    @Value("0")
    private Integer bonusDano;

    @Column(name = "arm_descricao", nullable = false)
    @NotBlank(message = "Arma deve possuir uma descricao.")
    private String descricao;

    @Column(name = "arm_item_magico", nullable = false)
    @NotNull(message = "A arma é um item magico (1)? Ou item mundano (0) ?")
    @Value("false")
    private Boolean itemMagico;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_id_tbl_inventario")
    @Nullable
    private InventarioModel inventarioModelArma;

    public ArmaModel() {}

    public ArmaModel(String nome, String dano, Integer bonusAtaque, Integer bonusDano, String descricao, Boolean itemMagico) {
        this.nome = nome;
        this.dano = dano;
        this.bonusAtaque = bonusAtaque;
        this.bonusDano = bonusDano;
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

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public Integer getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(Integer bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public Integer getBonusDano() {
        return bonusDano;
    }

    public void setBonusDano(Integer bonusDano) {
        this.bonusDano = bonusDano;
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
    public InventarioModel getInventarioModelArma() {
        return inventarioModelArma;
    }

    public void setInventarioModelArma(@Nullable InventarioModel inventarioModelArma) {
        this.inventarioModelArma = inventarioModelArma;
    }
}
