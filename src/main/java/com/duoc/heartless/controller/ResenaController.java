package com.duoc.heartless.controller;

import com.duoc.heartless.model.Resena;
import com.duoc.heartless.service.ResenaService;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Controlador REST encargado de manejar las reseñas.
@RequestMapping("/api/v1/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping  // Obtiene todas las reseñas registradas.
    public ResponseEntity<List<Resena>> listarResenas() {
        System.out.println("[ResenaController] -> listarResenas");
        return ResponseEntity.ok(resenaService.getResenas());
    }
    
    @PostMapping("/{libroId}")  // Agrega una nueva reseña asociada a un libro específico.
    public ResponseEntity<Resena> agregarResena(
            @PathVariable Integer libroId, 
            @RequestBody Resena resena) {
        System.out.println("[ResenaController] -> agregarResena");      
    
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resenaService.saveResena(resena, libroId));    
        

    }

    @GetMapping("/{id}")  // Busca una reseña usando su ID.
    public ResponseEntity<Resena> buscarResena(@PathVariable Integer id) {
        System.out.println("[ResenaController] -> buscarResena id=" + id);

        Resena resena = resenaService.getResenaId(id);

        if (resena == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resena);
    }

    @PutMapping("/{id}")  // Actualiza una reseña usando su ID.
    public ResponseEntity<Resena> actualizarResena( @PathVariable Integer id, @RequestBody Resena resena) {
        System.out.println("[ResenaController] -> actualizarResena id=" + id);
        resena.setId_resena(id);

        Resena actualizado = resenaService.updateResena(resena);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }


    @DeleteMapping("/{id}")  // Elimina una reseña usando su ID.
    public ResponseEntity<Void> eliminarResena(@PathVariable Integer id) {
        System.out.println("[ResenaController] -> eliminarResena id=" + id);

        boolean eliminado = resenaService.deleteResena(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/test-error")  // Endpoint de prueba para generar un error y verificar el manejo de excepciones.
    public ResponseEntity<Resena> testError() {
        System.out.println("[ResenaController] -> testError");
        throw new RuntimeException("Error de prueba en ResenaController");
    }

}

// Controlador encargado de manejar las reseñas de libros. Gestiona las reseñas asociadas a libros. Permite crear reseñas, listar reseñas, actualizar reseñas y eliminar reseñas. Cada reseña está vinculada a un libro específico.