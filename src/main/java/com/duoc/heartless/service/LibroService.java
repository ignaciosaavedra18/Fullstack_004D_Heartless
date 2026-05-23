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


@Service  // Servicio encargado de la lógica de negocio de libros. Aquí se validan y gestionan los libros.
public class LibroService {

    @Autowired  // Inyección de dependencia del repositorio de libros para acceder a la base de datos.
    private LibroRepository libroRepository;

    @Autowired // Inyección de dependencia del repositorio de autores para acceder a la base de datos.
    private AutorRepository autorRepository;

    
    private static final Logger logger =  // Logger para registrar información sobre las operaciones realizadas en el servicio de libros. 
            LoggerFactory.getLogger(LibroService.class);
    
    public List<Libro> getLibros() {  // Devuelve una lista de todos los libros.
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro, Integer autorId) { // Guarda un nuevo libro en la base de datos. Asocia el libro con un autor existente.
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        libro.setAutor(autor);
        logger.info("Guardando libro: {}", libro.getNombre());
        return libroRepository.save(libro);
    }

    public Libro getLibroId(Integer id) {  // Busca un libro por su ID. Si no se encuentra, lanza una excepción.
        return libroRepository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Libro no encontrado"));
    
    }
    public Libro updateLibro(Integer id, Libro libroactualizado) {  // Actualiza un libro existente. Si el libro no existe, lanza una excepción.
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setNombre(libroactualizado.getNombre());
        libro.setGenero(libroactualizado.getGenero());
        libro.setFechaDeinicio(libroactualizado.getFechaDeinicio());
        libro.setFechaDetermino(libroactualizado.getFechaDetermino());
        libro.setPagina(libroactualizado.getPagina());
        libro.setSinopsis(libroactualizado.getSinopsis());
        
        logger.info("Actualizando libro con id {}", id);  // Registra una información sobre la actualización del libro con su ID.

    return libroRepository.save(libro);  // Guarda el libro actualizado en la base de datos y lo devuelve.
    }

    public void deleteLibro(Integer id) {  // Elimina un libro por su ID. Si el libro no existe, lanza una excepción.
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteById(id);
    }
}


// Servicio encargado de la lógica de negocio de libros. Aquí se validan y gestionan los libros.