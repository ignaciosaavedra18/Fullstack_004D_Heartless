package com.duoc.heartless.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer id_autor;

    private String nombre;

    private int edad;

    private String genero;

    private String nacionalidad;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

}



// MODELS: Son las entidades que representan tablas de la base de datos. En este caso, la clase Autor representa la tabla "autores". Cada instancia de Autor corresponde a una fila en la tabla.
// Entidad que representa un autor en la base de datos. Contiene atributos del autor como: id nombre nacionalidad