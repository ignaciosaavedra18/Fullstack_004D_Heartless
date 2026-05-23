package com.duoc.heartless.service;

import com.duoc.heartless.model.Resena;
import com.duoc.heartless.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.heartless.model.Libro;
import com.duoc.heartless.repository.LibroRepository;


import java.util.List;

@Service  // Servicio que administra la lógica relacionada con reseñas. Maneja las operaciones de reseñas.
public class ResenaService {

    @Autowired // Inyección de dependencia del repositorio de reseñas para acceder a la base de datos.
    private ResenaRepository resenaRepository;

    @Autowired  // Inyección de dependencia del repositorio de libros para acceder a la base de datos.
    private LibroRepository libroRepository;
    
    public List<Resena> getResenas() {  // Devuelve una lista de todas las reseñas.
        return resenaRepository.findAll();
    }

    public Resena saveResena(Resena resena, Integer libroId) {  // Guarda una nueva reseña en la base de datos. Asocia la reseña con un libro existente.
        Libro libro = libroRepository.findById(libroId)
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        resena.setLibro(libro);

        return resenaRepository.save(resena); // Guarda la reseña en la base de datos y la devuelve.
    }

    public Resena getResenaId(Integer id) {  // Busca una reseña por su ID. Si no se encuentra, devuelve null.
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena updateResena(Resena resena) {  // Actualiza una reseña existente. Si la reseña no existe, lanza una excepción. 

    Resena existente = resenaRepository.findById(resena.getId_resena())
            .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));

   
    resena.setLibro(existente.getLibro());

    return resenaRepository.save(resena);
}

    public boolean deleteResena(Integer id) {  // Elimina una reseña por su ID. Si la reseña existe, la elimina y devuelve true. Si no existe, devuelve false.
        if (resenaRepository.existsById(id)) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
// Servicio que administra la lógica relacionada con reseñas. Maneja las operaciones de reseñas.
