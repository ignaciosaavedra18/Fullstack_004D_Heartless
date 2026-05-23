package com.duoc.heartless.service;

import com.duoc.heartless.model.Autor;
import com.duoc.heartless.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Servicio que contiene la lógica de negocio de autores.
public class AutorService {

    @Autowired  // Inyección de dependencia del repositorio de autores para acceder a la base de datos.
    private AutorRepository autorRepository;
    
    public List<Autor> getAutores() {  // Devuelve una lista de todos los autores.
        return autorRepository.findAll();
    }

    public Autor saveAutor(Autor autor) {  // Guarda un nuevo autor en la base de datos.
        return autorRepository.save(autor);
    }

    public Autor getAutorId(Integer id) {  // Busca un autor por su ID. Si no se encuentra, devuelve null.
        return autorRepository.findById(id).orElse(null);
    }

    public Autor updateAutor(Autor autor) {  // Actualiza un autor existente. Si el autor no existe, devuelve null.
        if (!autorRepository.existsById(autor.getId_autor())) {
            return null; 
        }
        return autorRepository.save(autor);
    }

    public boolean deleteAutor(Integer id) {  // Elimina un autor por su ID. Devuelve true si se eliminó correctamente, false si no se encontró el autor.
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

// SERVICE: Los services contienen la lógica de negocio.
// Servicio que contiene la lógica de negocio de autores. Procesa las operaciones antes de llegar a la base de datos. 