package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.JogadorDto;
import com.jogorpgmesa.jogo.model.JogadorModel;
import com.jogorpgmesa.jogo.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("jogorpg/")
public class JogadorController {
    @Autowired
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping("jogador/")
    public ResponseEntity<JogadorModel> saveJogador(@RequestBody JogadorDto jogadorDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.jogadorService.saveJogador(jogadorDto));
    }

    @GetMapping("jogador/:id")
    public ResponseEntity<JogadorModel> getJogador(@RequestParam(name = "id")UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.jogadorService.getJogador(id));
    }

    @GetMapping("jogador/:nome")
    public ResponseEntity<JogadorModel> getJogadorByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.jogadorService.getJogadorByNome(nome));
    }

    @GetMapping("jogadores/")
    public List<JogadorModel> getAllJogador() {
        return this.jogadorService.getAllJogador();
    }

    @PatchMapping("jogador/:id")
    public ResponseEntity<JogadorModel> updateJogador(
        @RequestParam(name = "id")
        UUID id,
        @RequestBody
        JogadorDto jogadorDto
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.jogadorService.updateJogador(id, jogadorDto));
    }

    @DeleteMapping("jogador/:id")
    public ResponseEntity<JogadorModel> deleteJogador(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.jogadorService.deleteJogador(id));
    }
}
