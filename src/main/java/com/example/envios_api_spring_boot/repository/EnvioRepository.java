package com.example.envios_api_spring_boot.repository;

import com.example.envios_api_spring_boot.models.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Integer> {
}
