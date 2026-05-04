package io.shnflrsc.sparky.entity;

import jakarta.persistence.*;

public record Dog(String name, String breed, int age) {}