package org.example.DogCrud.service;

import org.example.DogCrud.model.Dog;
import org.example.DogCrud.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Dog getDogById(Long id) {
        return dogRepository.findById(id).orElse(null);

    }

    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public Dog updateDog(Long id, Dog dog) {
        Dog existingDog = dogRepository.findById(id).orElse(null);
        if (existingDog != null) {
            // Update properties of existingDog with values from dog
            existingDog.setName(dog.getName());
            existingDog.setBreed(dog.getBreed());
            existingDog.setSex(dog.getSex());
            return dogRepository.save(existingDog);
        } else {
            return null;
        }
    }

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
}
