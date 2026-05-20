package com.duoc.heartless.repository;


import com.duoc.heartless.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResenaRepository extends JpaRepository<Resena, Integer> {
    
}

// Repositorio encargado del acceso a datos de reseñas. Gestiona las consultas relacionadas con reseñas.
