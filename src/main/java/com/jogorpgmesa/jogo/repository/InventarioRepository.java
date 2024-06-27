package com.jogorpgmesa.jogo.repository;

import com.jogorpgmesa.jogo.model.InventarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface InventarioRepository extends JpaRepository<InventarioModel, UUID> {
    @Query(value = "SELECT * FROM tbl_inventario WHERE per_id_tbl_personagem = :id LIMIT 1", nativeQuery = true)
    public InventarioModel findInventarioByPersonagemId(UUID id);

    @Query(value = "SELECT * FROM tbl_inventario WHERE per_id_tbl_personagem = :id", nativeQuery = true)
    public List<InventarioModel> findAllInventarioByPersonagemId(UUID id);
}
