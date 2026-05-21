package com.duoc.heartless.service;

import com.duoc.heartless.model.Resena;
import com.duoc.heartless.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoc.heartless.model.Libro;
import com.duoc.heartless.repository.LibroRepository;


import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private LibroRepository libroRepository;
    
    public List<Resena> getResenas() {
        return resenaRepository.findAll();
    }

    public Resena saveResena(Resena resena, Integer libroId) {
        Libro libro = libroRepository.findById(libroId)
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        resena.setLibro(libro);

        return resenaRepository.save(resena);
    }

    public Resena getResenaId(Integer id) {
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena updateResena(Resena resena) {

    Resena existente = resenaRepository.findById(resena.getId_resena())
            .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));

   
    resena.setLibro(existente.getLibro());

    return resenaRepository.save(resena);
}

    public boolean deleteResena(Integer id) {
        if (resenaRepository.existsById(id)) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
// Servicio que administra la lógica relacionada con reseñas. Maneja las operaciones de reseñas.
