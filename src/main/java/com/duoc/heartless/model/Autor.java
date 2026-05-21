package com.duoc.heartless.model;


import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="autores")
@Getter
@Setter
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;

    private String nombre;

    private int edad;

    private String genero;

    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros = new ArrayList<>();

}


// MODELS: Son las entidades que representan tablas de la base de datos. En este caso, la clase Autor representa la tabla "autores". Cada instancia de Autor corresponde a una fila en la tabla.
// Entidad que representa un autor en la base de datos. Contiene atributos del autor como: id nombre nacionalidad