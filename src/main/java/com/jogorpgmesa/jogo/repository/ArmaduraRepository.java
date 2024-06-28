package com.jogorpgmesa.jogo.repository;

import com.jogorpgmesa.jogo.model.ArmaduraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface ArmaduraRepository extends JpaRepository<ArmaduraModel, UUID> {
    public ArmaduraModel findByNome(String nome);

    @Query(value = "SELECT * FROM tbl_armadura WHERE armo_item_magico = 1", nativeQuery = true)
    public List<ArmaduraModel> findArmadurasByItemMagico();

    @Query(value = "SELECT * FROM tbl_armadura WHERE armo_item_magico = 0", nativeQuery = true)
    public List<ArmaduraModel> findArmadurasByItemMundano();

    public List<ArmaduraModel> findAllByNome(String nome);
}
