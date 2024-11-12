package org.example.DogCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.DogCrud.model.validation.ValidSex;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotBlank(message = "Breed is mandatory")
    private String breed;

    @ValidSex
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Sex is mandatory")
    private Sex sex;

    public enum Sex {
        FEMALE, MALE
    }
}
