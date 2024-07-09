package com.jogorpgmesa.jogo.repository;

import com.jogorpgmesa.jogo.model.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JogadorRepository extends JpaRepository<JogadorModel, UUID> {
    public JogadorModel findByNome(String nome);
}
