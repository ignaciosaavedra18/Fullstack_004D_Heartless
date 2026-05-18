package com.duoc.heartless.controller;

import com.duoc.heartless.model.Libro;
import com.duoc.heartless.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@Valid @RequestBody Libro libro) {
        System.out.println("[LibroController] -> agregarLibro");
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.saveLibro(libro));
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
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id,  @RequestBody Libro libro) {
        System.out.println("[LibroController] -> actualizarLibro id=" + id);
        libro.setLibroId(id);
        Libro actualizado = libroService.updateLibro(libro);
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