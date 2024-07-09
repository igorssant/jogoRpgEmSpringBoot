package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.PersonagemDto;
import com.jogorpgmesa.jogo.model.PersonagemModel;
import com.jogorpgmesa.jogo.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
