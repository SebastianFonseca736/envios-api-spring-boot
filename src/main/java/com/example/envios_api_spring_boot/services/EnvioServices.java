package com.example.envios_api_spring_boot.services;

import com.example.envios_api_spring_boot.models.Envio;
import com.example.envios_api_spring_boot.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServices {

    @Autowired
    private EnvioRepository envioRepository;

    // Obtener todos los envíos
    public List<Envio> findAll() {
        return envioRepository.findAll();
    }

    // Obtener un envío por su id
    public Optional<Envio> findById(Integer id) {
    return envioRepository.findById(id);
}

    // Agregar un nuevo envío
    public Envio save(Envio envio) {
        if (envio.getIdEnvio() != null && envioRepository.existsById(envio.getIdEnvio())) {
            return null;
        }
        return envioRepository.save(envio);
    }

    // Actualizar un envío existente
    public Envio update(Integer id, Envio envio) {
        if (envioRepository.existsById(id)) {
            envio.setIdEnvio(id);
            return envioRepository.save(envio);
        }
        return null;
    }

    // Eliminar un envío por su id
    public Envio delete(Integer id) {
        Optional<Envio> envio = envioRepository.findById(id);
        if (envio.isPresent()) {
            envioRepository.deleteById(id);
            return envio.get();
        }
        return null;
    }
}