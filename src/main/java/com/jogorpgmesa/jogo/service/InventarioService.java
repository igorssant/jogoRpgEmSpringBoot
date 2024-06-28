package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.InventarioDto;
import com.jogorpgmesa.jogo.model.InventarioModel;
import com.jogorpgmesa.jogo.repository.InventarioRepository;
import com.jogorpgmesa.jogo.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class InventarioService {
    @Autowired
    private final InventarioRepository inventarioRepository;

    @Autowired
    private final PersonagemRepository personagemRepository;

    public InventarioService(InventarioRepository inventarioRepository, PersonagemRepository personagemRepository) {
        this.inventarioRepository = inventarioRepository;
        this.personagemRepository = personagemRepository;
    }

    @Transactional
    public InventarioModel saveInventario(InventarioDto inventarioDto) {
        InventarioModel novoInventario = new InventarioModel();

        novoInventario.setDonoInventario(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.personagemRepository.findById(inventarioDto.donoInventario()).isPresent() ?
                this.personagemRepository.findById(inventarioDto.donoInventario()).get() : null
        );

        return this.inventarioRepository.save(novoInventario);
    }

    @Transactional
    public InventarioModel getInventario(UUID id) {
        return this.inventarioRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario " + id + " não existe."));
    }

    @Transactional
    public List<InventarioModel> getAllInventario() {
        return this.inventarioRepository.findAll();
    }

    @Transactional
    public InventarioModel getInventarioByPersonagemId(UUID id) {
        return this.inventarioRepository.findInventarioByPersonagemId(id);
    }

    @Transactional
    public List<InventarioModel> getAllInventarioByPersonagemId(UUID id) {
        return this.inventarioRepository.findAllInventarioByPersonagemId(id);
    }

    @Transactional
    public InventarioModel updateInventario(UUID id, InventarioDto inventarioDto) {
        InventarioModel inventarioDoBD = this.inventarioRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario " + id + " não existe."));

        inventarioDoBD.setDonoInventario(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.personagemRepository.findById(inventarioDto.donoInventario()).isPresent() ?
                this.personagemRepository.findById(inventarioDto.donoInventario()).get() : null
        );

        return this.inventarioRepository.save(inventarioDoBD);
    }

    @Transactional
    public InventarioModel deleteInventario(UUID id) {
        InventarioModel inventarioDoBD = this.inventarioRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Inventario " + id + " não existe."));

        this.inventarioRepository.deleteById(id);
        return inventarioDoBD;
    }
}
