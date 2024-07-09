package com.jogorpgmesa.jogo.service;

import com.jogorpgmesa.jogo.dto.JogadorDto;
import com.jogorpgmesa.jogo.model.JogadorModel;
import com.jogorpgmesa.jogo.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class JogadorService {
    @Autowired
    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    public JogadorModel saveJogador(JogadorDto jogadorDto) {
        JogadorModel novoJogador = new JogadorModel();

        novoJogador.setNome(jogadorDto.nome());
        novoJogador.setMestre(jogadorDto.mestre());
        novoJogador.setPersonagemModelSet(null);

        return this.jogadorRepository.save(novoJogador);
    }

    @Transactional
    public JogadorModel getJogador(UUID id) {
        return this.jogadorRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Jogador " + id + " não existe."));
    }

    @Transactional
    public List<JogadorModel> getAllJogador() {
        return this.jogadorRepository.findAll();
    }

    @Transactional
    public JogadorModel getJogadorByNome(String nome) {
        return this.jogadorRepository.findByNome(nome);
    }

    @Transactional
    public JogadorModel updateJogador(UUID id, JogadorDto jogadorDto) {
        JogadorModel jogadorDoBD = this.jogadorRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Jogador " + id + " não existe."));

        jogadorDoBD.setNome(jogadorDto.nome());
        jogadorDoBD.setMestre(jogadorDto.mestre());

        return this.jogadorRepository.save(jogadorDoBD);
    }

    @Transactional
    public JogadorModel deleteJogador(UUID id) {
        JogadorModel jogadorDoBD = this.jogadorRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Jogador " + id + " não existe."));

        this.jogadorRepository.deleteById(id);
        return jogadorDoBD;
    }
}
