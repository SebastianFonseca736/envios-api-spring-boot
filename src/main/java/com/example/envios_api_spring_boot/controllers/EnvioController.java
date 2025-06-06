package com.example.envios_api_spring_boot.controllers;

import com.example.envios_api_spring_boot.models.Envio;
import com.example.envios_api_spring_boot.services.EnvioServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.envios_api_spring_boot.services.EnvioEstadoHistorialService;
import com.example.envios_api_spring_boot.models.EnvioEstadoHistorial;
import java.util.List;

@RestController
@RequestMapping("/api/v1/envio")
public class EnvioController {

    @Autowired
    private EnvioServices envioServices;

    @GetMapping
    public ResponseEntity<List<Envio>> getAll() {
        return ResponseEntity.ok(envioServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        var envioOpt = envioServices.findById(id);
        if (envioOpt.isPresent()) {
            return ResponseEntity.ok(envioOpt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
  }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Envio nuevoEnvio) {
        Envio creado = envioServices.save(nuevoEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Envio envio) {
        Envio actualizado = envioServices.update(id, envio);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Envio eliminado = envioServices.delete(id);
        if (eliminado != null) {
            return ResponseEntity.ok(eliminado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
    }
}