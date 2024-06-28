package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.ArmaduraDto;
import com.jogorpgmesa.jogo.model.ArmaduraModel;
import com.jogorpgmesa.jogo.service.ArmaduraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("jogorpg/itens/")
public class ArmaduraController {
    @Autowired
    private final ArmaduraService armaduraService;

    public ArmaduraController(ArmaduraService armaduraService) {
        this.armaduraService = armaduraService;
    }

    @PostMapping("armadura/")
    public ResponseEntity<ArmaduraModel> saveArmadura(@RequestBody ArmaduraDto armaduraDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.armaduraService.saveArmadura(armaduraDto));
    }

    @GetMapping("armadura/:id")
    public ResponseEntity<ArmaduraModel> getArmadura(@RequestParam(name = "id") UUID id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaduraService.getArmadura(id));
    }

    @GetMapping("armaduras/")
    public List<ArmaduraModel> getAllArmadura() {
        return this.armaduraService.getAllArmadura();
    }

    @GetMapping("armadura/:nome")
    public List<ArmaduraModel> getArmaduraByNome(@RequestParam(name = "nome") String nome) {
        return this.armaduraService.getArmaduraByNome(nome);
    }

    @DeleteMapping("armadura/:id")
    public ResponseEntity<ArmaduraModel> deleteArmadura(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaduraService.deleteArmadura(id));
    }

    @PatchMapping("armadura/:id")
    public ResponseEntity<ArmaduraModel> updateArmadura(
            @RequestParam(name = "id")
            UUID id,
            @RequestBody
            ArmaduraDto armaduraDto
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaduraService.updateArmadura(
                id,
                armaduraDto
            ));
    }
}
