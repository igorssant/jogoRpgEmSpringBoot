package com.jogorpgmesa.jogo.dto;

import java.util.UUID;

public record ArmaduraDto(
        String nome,
        String dano,
        Integer bonusDefesa,
        Integer penalidadeArmadura,
        String descricao,
        Boolean itemMagico,
        UUID inventarioModelArma
) {}
