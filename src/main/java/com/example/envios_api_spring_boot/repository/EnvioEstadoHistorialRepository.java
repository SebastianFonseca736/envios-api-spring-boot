package com.example.envios_api_spring_boot.repository;

import com.example.envios_api_spring_boot.models.EnvioEstadoHistorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnvioEstadoHistorialRepository extends JpaRepository<EnvioEstadoHistorial, Integer> {
    List<EnvioEstadoHistorial> findByEnvioIdEnvio(Integer idEnvio);
}
