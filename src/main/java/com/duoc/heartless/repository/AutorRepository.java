package com.duoc.heartless.repository;


import com.duoc.heartless.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {


}

// Los repositories permiten conectarse con la base de datos.
// Repositorio encargado de acceder a los datos de autores. Usa JPA para hacer consultas automáticamente.