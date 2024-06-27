package com.jogorpgmesa.jogo.dto;

import java.util.UUID;

public record ArmaDto(
        String nome,
        String dano,
        Integer bonusAtaque,
        Integer bonusDano,
        String descricao,
        Boolean itemMagico,
        UUID inventarioModelArma
) {}
