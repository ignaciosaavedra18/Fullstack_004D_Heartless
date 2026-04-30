package com.duoc.heartless.repository;


import com.duoc.heartless.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
}
