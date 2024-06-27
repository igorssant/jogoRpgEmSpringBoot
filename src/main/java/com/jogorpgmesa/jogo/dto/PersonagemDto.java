package com.jogorpgmesa.jogo.dto;

import java.util.UUID;

public record PersonagemDto(
        String nome,
        Integer idade,
        Character sexo,
        Double altura,
        Double peso,
        Integer classe,
        Integer origem,
        Integer deus,
        UUID donoPersonagem
) {}
