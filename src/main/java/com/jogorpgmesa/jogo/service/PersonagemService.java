package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.PersonagemDto;
import com.jogorpgmesa.jogo.model.PersonagemModel;
import com.jogorpgmesa.jogo.repository.JogadorRepository;
import com.jogorpgmesa.jogo.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class PersonagemService {
    @Autowired
    private final PersonagemRepository personagemRepository;

    @Autowired
    private final JogadorRepository jogadorRepository;

    public PersonagemService(PersonagemRepository personagemRepository, JogadorRepository jogadorRepository) {
        this.personagemRepository = personagemRepository;
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    public PersonagemModel savePersonagem(PersonagemDto personagemDto) {
        PersonagemModel novoPersonagem = new PersonagemModel();

        novoPersonagem.setNome(personagemDto.nome());
        novoPersonagem.setIdade(personagemDto.idade());
        novoPersonagem.setSexo(personagemDto.sexo());
        novoPersonagem.setAltura(personagemDto.altura());
        novoPersonagem.setPeso(personagemDto.peso());
        novoPersonagem.setClasse(personagemDto.deus());
        novoPersonagem.setOrigem(personagemDto.origem());
        novoPersonagem.setDeus(personagemDto.deus());
        novoPersonagem.setDonoPersonagem(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.jogadorRepository.findById(personagemDto.donoPersonagem()).isPresent()?
                this.jogadorRepository.findById(personagemDto.donoPersonagem()).get() : null
        );

        return this.personagemRepository.save(novoPersonagem);
    }

    @Transactional
    public PersonagemModel getPersonagem(UUID id) {
        return this.personagemRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Personagem " + id + " não existe."));
    }

    @Transactional
    public List<PersonagemModel> getPersonagensByJogadorId(UUID id) {
        return this.personagemRepository.findPersonagensByJogadorId(id);
    }

    @Transactional
    public List<PersonagemModel> getAllPersonagem() {
        return this.personagemRepository.findAll();
    }

    @Transactional
    public PersonagemModel updatePersonagem(UUID id, PersonagemDto personagemDto) {
        PersonagemModel personagemDoBD = this.personagemRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Personagem " + id + " não existe."));

        personagemDoBD.setNome(personagemDto.nome());
        personagemDoBD.setIdade(personagemDto.idade());
        personagemDoBD.setSexo(personagemDto.sexo());
        personagemDoBD.setAltura(personagemDto.altura());
        personagemDoBD.setPeso(personagemDto.peso());
        personagemDoBD.setClasse(personagemDto.deus());
        personagemDoBD.setOrigem(personagemDto.origem());
        personagemDoBD.setDeus(personagemDto.deus());
        personagemDoBD.setDonoPersonagem(
            /*
             * VERIFICA SE O ID ESTA PRESENTE NO DTO
             * SE NAO ESTIVER
             * SALVA O VALOR null
             */
            this.jogadorRepository.findById(personagemDto.donoPersonagem()).isPresent()?
                this.jogadorRepository.findById(personagemDto.donoPersonagem()).get() : null
        );

        return this.personagemRepository.save(personagemDoBD);
    }

    @Transactional
    public PersonagemModel deletePersonagem(UUID id) {
        PersonagemModel personagemDoBD = this.personagemRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Personagem " + id + " não existe."));

        this.personagemRepository.deleteById(id);
        return personagemDoBD;
    }
}
