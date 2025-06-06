package com.example.envios_api_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnvioDTO {
    private Integer idEnvio;
    private Integer idVenta;
    private String direccionEnvio;
    private String estadoEnvio;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
}