package com.example.envios_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "envio_estado_historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvioEstadoHistorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_envio")
    private Envio envio;

    private String estado;

    private LocalDateTime fechaCambio;
}