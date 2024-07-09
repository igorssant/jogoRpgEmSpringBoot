package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.ArmaDto;
import com.jogorpgmesa.jogo.model.ArmaModel;
import com.jogorpgmesa.jogo.repository.ArmaRepository;
import com.jogorpgmesa.jogo.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ArmaService {
    @Autowired
    private final ArmaRepository armaRepository;

    @Autowired
    private final InventarioRepository inventarioRepository;

    public ArmaService(ArmaRepository armaRepository, InventarioRepository inventarioRepository) {
        this.armaRepository = armaRepository;
        this.inventarioRepository = inventarioRepository;
    }

    @Transactional
    public ArmaModel saveArma(ArmaDto armaDto) {
        ArmaModel novaArma = new ArmaModel();

        novaArma.setNome(armaDto.nome());
        novaArma.setDano(armaDto.dano());
        novaArma.setBonusAtaque(armaDto.bonusAtaque());
        novaArma.setBonusDano(armaDto.bonusDano());
        novaArma.setDescricao(armaDto.descricao());
        novaArma.setItemMagico(armaDto.itemMagico());
        novaArma.setInventarioModelArma(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.inventarioRepository.findById(armaDto.inventarioModelArma()).isPresent() ?
                    this.inventarioRepository.findById(armaDto.inventarioModelArma()).get() : null
        );

        return this.armaRepository.save(novaArma);
    }

    @Transactional
    public ArmaModel getArma(UUID id) {
        return this.armaRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Arma " + id + " não existe."));
    }

    @Transactional
    public List<ArmaModel> getAllArma() {
        return this.armaRepository.findAll();
    }

    @Transactional
    public ArmaModel updateArma(UUID id, ArmaDto armaDto) {
        ArmaModel armaDoBD = this.armaRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Arma " + id + " não existe."));

        armaDoBD.setNome(armaDto.nome());
        armaDoBD.setDano(armaDto.dano());
        armaDoBD.setBonusAtaque(armaDto.bonusAtaque());
        armaDoBD.setBonusDano(armaDto.bonusDano());
        armaDoBD.setDescricao(armaDto.descricao());
        armaDoBD.setItemMagico(armaDto.itemMagico());
        armaDoBD.setInventarioModelArma(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.inventarioRepository.findById(armaDto.inventarioModelArma()).isPresent() ?
                this.inventarioRepository.findById(armaDto.inventarioModelArma()).get() : null
        );

        return this.armaRepository.save(armaDoBD);
    }

    @Transactional
    public ArmaModel deleteArma(UUID id) {
        ArmaModel armaDoBD = this.armaRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Arma " + id + " não existe."));

        this.armaRepository.deleteById(id);
        return armaDoBD;
    }

    @Transactional
    public List<ArmaModel> getArmaByNome(String nome) {
        return this.armaRepository.findAllByNome(nome);
    }
}
