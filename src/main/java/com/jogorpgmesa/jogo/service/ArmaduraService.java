package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.ArmaduraDto;
import com.jogorpgmesa.jogo.model.ArmaduraModel;
import com.jogorpgmesa.jogo.repository.ArmaduraRepository;
import com.jogorpgmesa.jogo.repository.InventarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArmaduraService {
    private final ArmaduraRepository armaduraRepository;
    private final InventarioRepository inventarioRepository;

    public ArmaduraService(ArmaduraRepository armaduraRepository, InventarioRepository inventarioRepository) {
        this.armaduraRepository = armaduraRepository;
        this.inventarioRepository = inventarioRepository;
    }

    @Transactional
    public ArmaduraModel saveArmadura(ArmaduraDto armaduraDto) {
        ArmaduraModel armadura = new ArmaduraModel();

        armadura.setNome(armaduraDto.nome());
        armadura.setBonusDefesa(armaduraDto.bonusDefesa());
        armadura.setPenalidadeArmadura(armaduraDto.penalidadeArmadura());
        armadura.setDescricao(armaduraDto.descricao());
        armadura.setItemMagico(armaduraDto.itemMagico());
        armadura.setInventarioModelArmadura(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).isPresent() ?
                inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).get() : null
        );

        return armaduraRepository.save(armadura);
    }
}
