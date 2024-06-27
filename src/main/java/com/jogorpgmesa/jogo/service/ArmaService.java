package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.ArmaDto;
import com.jogorpgmesa.jogo.model.ArmaModel;
import com.jogorpgmesa.jogo.repository.ArmaRepository;
import com.jogorpgmesa.jogo.repository.InventarioRepository;

public class ArmaService {
    private final ArmaRepository armaRepository;
    private final InventarioRepository inventarioRepository;

    public ArmaService(ArmaRepository armaRepository, InventarioRepository inventarioRepository) {
        this.armaRepository = armaRepository;
        this.inventarioRepository = inventarioRepository;
    }

    public ArmaModel saveArma(ArmaDto armaDto) {
        return armaRepository.save(arma);
    }
}
