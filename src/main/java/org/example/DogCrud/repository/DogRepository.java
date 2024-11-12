package org.example.DogCrud.repository;

import org.example.DogCrud.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {

}
