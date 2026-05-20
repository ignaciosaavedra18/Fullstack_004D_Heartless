package com.duoc.heartless.controller;

import com.duoc.heartless.model.Autor;
import com.duoc.heartless.service.AutorService;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

   @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        System.out.println("[AutorController] -> listarAutores");
        return ResponseEntity.ok(autorService.getAutores());
    }

    @PostMapping
    public ResponseEntity<Autor> agregarAutor(@RequestBody Autor autor) {
        System.out.println("[AutorController] -> agregarAutor");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorService.saveAutor(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable Integer id) {
        System.out.println("[AutorController] -> buscarAutor id=" + id);

        Autor autor = autorService.getAutorId(id);

        if (autor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(
            @PathVariable Integer id,
            @RequestBody Autor autor) {

        System.out.println("[AutorController] -> actualizarAutor id=" + id);
        autor.setId(id); // Asegura que el ID del autor a actualizar se establezca correctamente

        Autor actualizado = autorService.updateAutor(autor);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable Integer id) {

        System.out.println("[AutorController] -> eliminarAutor id=" + id);

        autorService.deleteAutor(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test-error")
    public ResponseEntity<Autor> testError() {

        System.out.println("[AutorController] -> testError");

        throw new RuntimeException("Este es un error de prueba lanzado intencionalmente");
    }
}

// Los controllers reciben las peticiones HTTP desde Postman o el navegador. 
// Controlador encargado de manejar las peticiones relacionadas con autores. Maneja endpoints como: GET |POST PUT DELETE para los autores.