package com.jogorpgmesa.jogo.repository;

import com.jogorpgmesa.jogo.model.ArmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface ArmaRepository extends JpaRepository<ArmaModel, UUID> {
    public ArmaModel findArmaModelByNome(String nome);

    @Query(value = "SELECT * FROM tbl_arma WHERE arm_item_magico = 1", nativeQuery = true)
    public List<ArmaModel> findArmasByItemMagico();

    @Query(value = "SELECT * FROM tbl_arma WHERE arm_item_magico = 0", nativeQuery = true)
    public List<ArmaModel> findArmasByItemMundano();
}
