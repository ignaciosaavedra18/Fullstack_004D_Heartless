package com.duoc.heartless.service;

import com.duoc.heartless.model.Autor;
import com.duoc.heartless.model.Libro;
import com.duoc.heartless.repository.AutorRepository;
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

    @Autowired
    private AutorRepository autorRepository;

    
    private static final Logger logger =
            LoggerFactory.getLogger(LibroService.class);
    
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro, Integer autorId) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        libro.setAutor(autor);
        logger.info("Guardando libro: {}", libro.getNombre());
        return libroRepository.save(libro);
    }

    public Libro getLibroId(Integer id) {
        return libroRepository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Libro no encontrado"));
    
    }
    public Libro updateLibro(Integer id, Libro libroactualizado) { 
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setNombre(libroactualizado.getNombre());
        libro.setGenero(libroactualizado.getGenero());
         libro.setFecha_de_inicio(libroactualizado.getFecha_de_inicio());
        libro.setFecha_de_termino(libroactualizado.getFecha_de_termino());
        libro.setPagina(libroactualizado.getPagina());
        libro.setSinopsis(libroactualizado.getSinopsis());
        
        logger.info("Actualizando libro con id {}", id);

    return libroRepository.save(libro);
    }

    public void deleteLibro(Integer id) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteById(id);
    }
}


// Servicio encargado de la lógica de negocio de libros. Aquí se validan y gestionan los libros.