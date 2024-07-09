package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.PersonagemDto;
import com.jogorpgmesa.jogo.model.PersonagemModel;
import com.jogorpgmesa.jogo.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("jogorpg/")
public class PersonagemController {
    @Autowired
    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @PostMapping("personagem/")
    public ResponseEntity<PersonagemModel> savePersonagem(@RequestBody PersonagemDto personagemDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.personagemService.savePersonagem(personagemDto));
    }

    @GetMapping("personagem/:id")
    public ResponseEntity<PersonagemModel> getPersonagem(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.personagemService.getPersonagem(id));
    }

    @GetMapping("personagens/")
    public List<PersonagemModel> getAllPersonagem() {
        return this.personagemService.getAllPersonagem();
    }

    @GetMapping("personagens/jogador/:id")
    public List<PersonagemModel> getAllPersonagemByJogadorId(@RequestParam(name = "id") UUID id) {
        return this.personagemService.getPersonagensByJogadorId(id);
    }

    @PatchMapping("personagem/:id")
    public ResponseEntity<PersonagemModel> updatePersonagem(
        @RequestParam(name = "id")
        UUID id,
        @RequestBody
        PersonagemDto personagemDto
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.personagemService.updatePersonagem(
                id,
                personagemDto
            ));
    }

    @DeleteMapping("personagem/:id")
    public ResponseEntity<PersonagemModel> deletePersonagem(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.personagemService.deletePersonagem(id));
    }
}
