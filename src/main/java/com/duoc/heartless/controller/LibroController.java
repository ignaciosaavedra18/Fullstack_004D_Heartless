package com.duoc.heartless.controller;

import com.duoc.heartless.model.Libro;
import com.duoc.heartless.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        System.out.println("[LibroController] -> listarLibros");
        return ResponseEntity.ok(libroService.getLibros());
    }

    @PostMapping("/{autorId}")
    public ResponseEntity<Libro> agregarLibro(
            @PathVariable Integer autorId, @Valid @RequestBody Libro libro) {
        

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(libroService.saveLibro(libro, autorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Integer id) {
        System.out.println("[LibroController] -> buscarLibro id=" + id);
        Libro libro = libroService.getLibroId(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id, @Valid @RequestBody Libro libro) {
        System.out.println("[LibroController] -> actualizarLibro id=" + id);
        Libro actualizado = libroService.updateLibro(id, libro);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        System.out.println("[LibroController] -> eliminarLibro id=" + id);
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test-error")
    public ResponseEntity<Libro> testError() {
        System.out.println("[LibroController] -> testError");
        throw new RuntimeException("Este es un error de prueba lanzado intencionalmente");
    }
}

// Controlador que administra las operaciones CRUD de libros. Permite: listar libros crear libros actualizar libros eliminar libros