package com.duoc.heartless.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;


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

    @Min(value = 1)
    @Max(value = 5)
    private int clasificacion;

    private String opinion_libro;

    private String fecha_publicacion;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    @JsonBackReference
    private Libro libro;
        
}
// Entidad que representa una reseña realizada a un libro que estas contienen una relacion. Guarda comentarios o valoraciones de libros.
