package com.duoc.heartless.service;

import com.duoc.heartless.model.Libro;
import com.duoc.heartless.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    
    private static final Logger logger =
            LoggerFactory.getLogger(LibroService.class);
    
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro) {
        logger.info("Guardando libro: {}", libro.getNombre());
        return libroRepository.save(libro);
    }

    public Libro getLibroId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro libro) { 
        if (!libroRepository.existsById(libro.getLibroId())) {
            return null; 
        }
        return libroRepository.save(libro);
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}

// Servicio encargado de la lógica de negocio de libros. Aquí se validan y gestionan los libros.