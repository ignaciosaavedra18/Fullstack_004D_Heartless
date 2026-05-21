package com.duoc.heartless.model;


import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="autores")
public class Autor {

    @Id
    private int id_autor;

    private String nombre;

    private int edad;

    private String genero;

    private String nacionalidad;

    private Integer id;


}



// MODELS: Son las entidades que representan tablas de la base de datos. En este caso, la clase Autor representa la tabla "autores". Cada instancia de Autor corresponde a una fila en la tabla.
// Entidad que representa un autor en la base de datos. Contiene atributos del autor como: id nombre nacionalidad