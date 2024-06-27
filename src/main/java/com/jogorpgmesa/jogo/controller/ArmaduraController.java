package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.ArmaduraDto;
import com.jogorpgmesa.jogo.model.ArmaduraModel;
import com.jogorpgmesa.jogo.service.ArmaduraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jogorpg/itens")
public class ArmaduraController {
    private final ArmaduraService armaduraService;

    public ArmaduraController(ArmaduraService armaduraService) {
        this.armaduraService = armaduraService;
    }

    @PostMapping(name = "/armadura")
    public ResponseEntity<ArmaduraModel> saveArmadura(@RequestBody ArmaduraDto armaduraDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(armaduraService.saveArmadura(armaduraDto));
    }
}
