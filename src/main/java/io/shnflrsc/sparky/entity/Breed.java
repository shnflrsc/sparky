package io.shnflrsc.sparky.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breeds")
public class Breed {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "breed", nullable = false)
    private String breed;

    public Breed(String breed) {
        this.breed = breed;
    }

    public Breed() {}

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
