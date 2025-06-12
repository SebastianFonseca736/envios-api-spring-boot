package com.example.envios_api_spring_boot.controllers;

import com.example.envios_api_spring_boot.models.Envio;
import com.example.envios_api_spring_boot.services.EnvioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/envio")
public class EnvioController {

    @Autowired
    private EnvioServices envioServices;

    // GET api/v1/envio
    @GetMapping
    public ResponseEntity<?> getAllEnvios() {
        return ResponseEntity.ok(envioServices.findAll());
    }

    // GET api/v1/envio/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getEnvioPorId(@PathVariable Integer id) {
        Envio envio = envioServices.findById(id).orElse(null);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
    }

    // POST api/v1/envio
    @PostMapping
    public ResponseEntity<?> registrarEnvio(@RequestBody Envio nuevoEnvio) {
        Envio creado = envioServices.save(nuevoEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT api/v1/envio/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEnvio(@PathVariable Integer id, @RequestBody Envio envio) {
        Envio actualizado = envioServices.update(id, envio);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
    }

    // DELETE api/v1/envio/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEnvio(@PathVariable Integer id) {
        Envio eliminado = envioServices.delete(id);
        if (eliminado != null) {
            return ResponseEntity.ok(eliminado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Envío no encontrado");
    }
}

