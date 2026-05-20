package com.duoc.heartless.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int LibroId; 

    @NotBlank(message = "El nombre del libro no puede estar vacío")
    private String nombre;

    private String genero; 

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    private int fecha_de_incio;

    private int fecha_de_termino;

    @Min(value = 1, message = "La pagina debe ser mayor a 0")
    private int pagina;

    private String sinopsis;


}


// Entidad que representa un libro dentro del sistema. Contiene información del libro: título género autor reseñas