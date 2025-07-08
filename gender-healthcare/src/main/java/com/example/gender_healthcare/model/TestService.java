package com.example.genderhealthcare.model;

import jakarta.persistence.*;

@Entity
public class TestService {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private double price;

  // Constructors, getters, setters
  public TestService() {}
  public TestService(String name, String description, double price) {
    this.name = name; this.description = description; this.price = price;
  }
  // ... getters/setters omitted for brevity
}
