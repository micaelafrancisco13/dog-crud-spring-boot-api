package org.example.DogCrud.controller;

import jakarta.validation.Valid;
import org.example.DogCrud.model.Dog;
import org.example.DogCrud.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Dog dog = dogService.getDogById(id);
        return dog != null ? ResponseEntity.ok(dog) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Dog> createDog(@Valid @RequestBody Dog dog) {
        Dog createdDog = dogService.createDog(dog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @Valid @RequestBody Dog dog) {
        Dog updatedDog = dogService.updateDog(id, dog);
        return updatedDog != null ? ResponseEntity.ok(updatedDog) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }
}
