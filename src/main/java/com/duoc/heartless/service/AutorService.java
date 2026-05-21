package com.duoc.heartless.service;

import com.duoc.heartless.model.Autor;
import com.duoc.heartless.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    
    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getAutorId(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor updateAutor(Autor autor) { 
        if (!autorRepository.existsById(autor.getId_autor())) {
            return null; 
        }
        return autorRepository.save(autor);
    }

    public boolean deleteAutor(Integer id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

// SERVICE: Los services contienen la lógica de negocio.
// Servicio que contiene la lógica de negocio de autores. Procesa las operaciones antes de llegar a la base de datos. 