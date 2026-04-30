package com.duoc.heartless.service;

import com.duoc.heartless.model.Libro;
import com.duoc.heartless.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro getLibroId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro libro) { 
        if (!libroRepository.existsById(libro.getId())) {
            return null; 
        }
        return libroRepository.save(libro);
    }

    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}
