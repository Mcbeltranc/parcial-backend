package com.parcial.parcialbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String entrenador;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;
}
