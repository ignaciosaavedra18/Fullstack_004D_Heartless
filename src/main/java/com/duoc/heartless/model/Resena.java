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
@Table(name = "resenas")

public class Resena {

    @Id
    private int id_resena;

    private String formato;

    private int clasificacion;

    private String opinion_libro;

    private String fecha_publicacion;
    
    
    

    
}
