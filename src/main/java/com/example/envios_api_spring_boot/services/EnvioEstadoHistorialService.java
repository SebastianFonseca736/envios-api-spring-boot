package com.example.envios_api_spring_boot.services;

import com.example.envios_api_spring_boot.models.EnvioEstadoHistorial;
import com.example.envios_api_spring_boot.repository.EnvioEstadoHistorialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioEstadoHistorialService {

    private final EnvioEstadoHistorialRepository repository;

    public EnvioEstadoHistorialService(EnvioEstadoHistorialRepository repository) {
        this.repository = repository;
    }

    public List<EnvioEstadoHistorial> getHistorialByEnvio(Integer idEnvio) {
        return repository.findByEnvioIdEnvio(idEnvio);
    }

    public EnvioEstadoHistorial save(EnvioEstadoHistorial historial) {
        return repository.save(historial);
    }
}