package com.duoc.heartless.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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



}
