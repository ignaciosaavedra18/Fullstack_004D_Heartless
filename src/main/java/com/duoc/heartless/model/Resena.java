package com.duoc.heartless.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resenas")

public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_resena;

    private String formato;

    private int clasificacion;

    private String opinion_libro;

    private String fecha_publicacion;

    
}

// Entidad que representa una reseña realizada a un libro. Guarda comentarios o valoraciones de libros.