package com.duoc.heartless.model;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;
//import java.util.ArrayList;
import java.util.List;
//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="autores")  // Entidad que representa un autor en la base de datos.
public class Autor { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;

    private String nombre;

    private int edad;

    private String genero;

    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Libro> libros;  // Lista de libros asociados al autor.

}


// MODELS: Son las entidades que representan tablas de la base de datos. En este caso, la clase Autor representa la tabla "autores". Cada instancia de Autor corresponde a una fila en la tabla.
// Entidad que representa un autor en la base de datos. Contiene atributos del autor como: id nombre nacionalidad