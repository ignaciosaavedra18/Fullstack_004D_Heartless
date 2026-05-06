package com.duoc.heartless.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {

    @Id
    private int id_libro; 

    private String nombre;

    private String genero; 

    private String autor;

    private int fecha_de_incio;

    private int fecha_de_termino;

    private int pagina;

    private String sinopsis;





}
   