package com.duoc.heartless.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")  // Entidad que representa un libro en la base de datos.
public class Libro {  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente un ID único para cada libro.
    private Integer LibroId; 

    @NotBlank(message = "El nombre del libro no puede estar vacío")
    private String nombre;

    @NotBlank
    private String genero; 

    @Column(name = "fecha_de_inicio")
    private int fechaDeinicio;

    @Column(name = "fecha_de_termino")
    private int fechaDetermino;

    @Min(value = 1, message = "La pagina debe ser mayor a 0")
    private int pagina;

    @NotBlank
    private String sinopsis;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Autor autor;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resena> resenas = new ArrayList<>();
}

// Entidad que representa un libro dentro del sistema. Contiene información del libro: título género autor reseñas
// Relación del libro con el autor.