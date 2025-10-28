package com.symptomtriager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String symptoms;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Disease() {
    }

    // Constructor without id (preferred for saving new records)
    public Disease(String name, String symptoms, String description) {
        this.name = name;
        this.symptoms = symptoms;
        this.description = description;
    }

    // Constructor with id (optional, kept for compatibility)
    public Disease(Long id, String name, String symptoms, String description) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.description = description;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
