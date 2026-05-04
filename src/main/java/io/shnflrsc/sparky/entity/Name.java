package io.shnflrsc.sparky.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "names")
public class Name {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public Name() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
