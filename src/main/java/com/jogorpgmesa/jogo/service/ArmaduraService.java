package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.ArmaduraDto;
import com.jogorpgmesa.jogo.model.ArmaduraModel;
import com.jogorpgmesa.jogo.repository.ArmaduraRepository;
import com.jogorpgmesa.jogo.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ArmaduraService {
    @Autowired
    private final ArmaduraRepository armaduraRepository;

    @Autowired
    private final InventarioRepository inventarioRepository;

    public ArmaduraService(ArmaduraRepository armaduraRepository, InventarioRepository inventarioRepository) {
        this.armaduraRepository = armaduraRepository;
        this.inventarioRepository = inventarioRepository;
    }

    @Transactional
    public ArmaduraModel saveArmadura(ArmaduraDto armaduraDto) {
        ArmaduraModel novaArmadura = new ArmaduraModel();

        novaArmadura.setNome(armaduraDto.nome());
        novaArmadura.setBonusDefesa(armaduraDto.bonusDefesa());
        novaArmadura.setPenalidadeArmadura(armaduraDto.penalidadeArmadura());
        novaArmadura.setDescricao(armaduraDto.descricao());
        novaArmadura.setItemMagico(armaduraDto.itemMagico());
        novaArmadura.setInventarioModelArmadura(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).isPresent() ?
                this.inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).get() : null
        );

        return this.armaduraRepository.save(novaArmadura);
    }

    @Transactional
    public ArmaduraModel getArmadura(UUID id) {
        return armaduraRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Armadura " + id + " não existe."));
    }

    @Transactional
    public List<ArmaduraModel> getAllArmadura() {
        return this.armaduraRepository.findAll();
    }

    @Transactional
    public ArmaduraModel updateArmadura(UUID id, ArmaduraDto armaduraDto) {
        ArmaduraModel armaduraDoBD = this.armaduraRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Armadura " + id + " não existe."));

        armaduraDoBD.setNome(armaduraDto.nome());
        armaduraDoBD.setBonusDefesa(armaduraDto.bonusDefesa());
        armaduraDoBD.setPenalidadeArmadura(armaduraDto.penalidadeArmadura());
        armaduraDoBD.setDescricao(armaduraDto.descricao());
        armaduraDoBD.setItemMagico(armaduraDto.itemMagico());
        armaduraDoBD.setInventarioModelArmadura(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).isPresent()?
                this.inventarioRepository.findById(armaduraDto.inventarioModelArmadura()).get() : null
        );

        return armaduraRepository.save(armaduraDoBD);
    }

    @Transactional
    public ArmaduraModel deleteArmadura(UUID id) {
        ArmaduraModel armaduraDoBD = this.armaduraRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Armadura " + id + " não existe."));

        this.armaduraRepository.deleteById(id);
        return armaduraDoBD;
    }

    @Transactional
    public List<ArmaduraModel> getArmaduraByNome(String nome) {
        return this.armaduraRepository.findAllByNome(nome);
    }
}
