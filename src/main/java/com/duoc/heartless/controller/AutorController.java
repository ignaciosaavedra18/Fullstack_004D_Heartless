package com.duoc.heartless.controller;

import com.duoc.heartless.model.Autor;
import com.duoc.heartless.service.AutorService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // Controlador REST encargado de manejar las peticiones de autores.
@RequestMapping("/api/v1/autores")
@SecurityRequirement(name = "bearerAuth")
public class AutorController {

    @Autowired
    private AutorService autorService;

   @GetMapping  // Obtiene todos los autores registrados.
    public ResponseEntity<List<Autor>> listarAutores() {
        System.out.println("[AutorController] -> listarAutores");
        return ResponseEntity.ok(autorService.getAutores());
    }

    @PostMapping  // Agrega a un nuevo autor.
    public ResponseEntity<Autor> agregarAutor(@RequestBody Autor autor) {
        System.out.println("[AutorController] -> agregarAutor");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorService.saveAutor(autor));
    }

    @GetMapping("/{id}")  // Busca un autor usando su ID.
    public ResponseEntity<Autor> buscarAutor(@PathVariable Integer id) {
        System.out.println("[AutorController] -> buscarAutor id=" + id);

        Autor autor = autorService.getAutorId(id);

        if (autor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(autor);
    }

    @PutMapping("/{id}")   // Actualiza un autor usando su ID.
    public ResponseEntity<Autor> actualizarAutor(
            @PathVariable Integer id,
            @RequestBody Autor autor) {

        System.out.println("[AutorController] -> actualizarAutor id=" + id);
        autor.setId_autor(id); // Asegura que el ID del autor a actualizar se establezca correctamente

        Autor actualizado = autorService.updateAutor(autor);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")  // Elimina un autor usando su ID.
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