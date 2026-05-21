package com.duoc.heartless.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name="libros")
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LibroId; 

    @NotBlank(message = "El nombre del libro no puede estar vacío")
    private String nombre;

    private String genero; 

    private int fecha_de_incio;

    private int fecha_de_termino;

    @Min(value = 1, message = "La pagina debe ser mayor a 0")
    private int pagina;

    private String sinopsis;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonManagedReference
    private Autor autor;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Resena> resenas = new ArrayList<>();
}




// Entidad que representa un libro dentro del sistema. Contiene información del libro: título género autor reseñas