package com.jogorpgmesa.jogo.repository;

import com.jogorpgmesa.jogo.model.PersonagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface PersonagemRepository extends JpaRepository<PersonagemModel, UUID> {
    public PersonagemModel findPersonagemModelByNome(String nome);

    @Query(value = "SELECT * FROM tbl_personagem WHERE jog_id_tbl_jogador = :id", nativeQuery = true)
    public List<PersonagemModel> findPersonagensByJogadorId(@Param("id") UUID id);
}
