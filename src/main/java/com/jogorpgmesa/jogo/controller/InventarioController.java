package com.jogorpgmesa.jogo.controller;

import com.jogorpgmesa.jogo.dto.InventarioDto;
import com.jogorpgmesa.jogo.model.InventarioModel;
import com.jogorpgmesa.jogo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("jogorpg/")
public class InventarioController {
    @Autowired
    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping("inventario/")
    public ResponseEntity<InventarioModel> saveInventario(@RequestBody InventarioDto inventarioDto) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.inventarioService.saveInventario(inventarioDto));
    }

    @GetMapping("inventario/:id")
    public ResponseEntity<InventarioModel> getInventarioById(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.inventarioService.getInventario(id));
    }

    @GetMapping("inventario/personagem/:id")
    public ResponseEntity<InventarioModel> getInventarioByPersonagemId(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.inventarioService.getInventarioByPersonagemId(id));
    }

    @GetMapping("inventarios/")
    public List<InventarioModel> getAllInventario() {
        return this.inventarioService.getAllInventario();
    }

    @GetMapping("inventarios/personagem/:id")
    public List<InventarioModel> getAllInventarioByPersonagemId(@RequestParam(name = "id") UUID id) {
        return this.inventarioService.getAllInventarioByPersonagemId(id);
    }

    @PatchMapping("inventario/:id")
    public ResponseEntity<InventarioModel> updateInventario(
        @RequestParam(name = "id")
        UUID id,
        @RequestBody
        InventarioDto inventarioDto
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.inventarioService.updateInventario(id, inventarioDto));
    }

    @DeleteMapping("inventario/:id")
    public ResponseEntity<InventarioModel> deleteInventario(@RequestParam(name = "id") UUID id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.inventarioService.deleteInventario(id));
    }
}
