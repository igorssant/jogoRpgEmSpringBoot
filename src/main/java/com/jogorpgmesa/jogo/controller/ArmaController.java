package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.ArmaDto;
import com.jogorpgmesa.jogo.model.ArmaModel;
import com.jogorpgmesa.jogo.service.ArmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("jogorpg/itens/")
public class ArmaController {
    @Autowired
    private final ArmaService armaService;

    public ArmaController(ArmaService armaService) {
        this.armaService = armaService;
    }

    @PostMapping("arma/")
    public ResponseEntity<ArmaModel> saveArma(@RequestBody ArmaDto armaDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.armaService.saveArma(armaDto));
    }

    @GetMapping("arma/:id")
    public ResponseEntity<ArmaModel> getArma(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaService.getArma(id));
    }

    @GetMapping("armas/")
    public List<ArmaModel> getAllArma() {
        return this.armaService.getAllArma();
    }

    @GetMapping("armas/:nome")
    public List<ArmaModel> getAllArmaByNome(@RequestParam(name = "nome") String nome) {
        return this.armaService.getArmaByNome(nome);
    }

    @DeleteMapping("arma/:id")
    public ResponseEntity<ArmaModel> deleteArma(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaService.deleteArma(id));
    }

    @PatchMapping("arma/:id")
    public ResponseEntity<ArmaModel> updateArma(
        @RequestParam(name = "id")
        UUID id,
        @RequestBody
        ArmaDto armaDto
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.armaService.updateArma(
                id,
                armaDto
            ));
    }
}
