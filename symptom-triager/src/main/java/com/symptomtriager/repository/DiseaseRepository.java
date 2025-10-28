package com.symptomtriager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.symptomtriager.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    @Query("SELECT d FROM Disease d WHERE LOWER(d.symptoms) LIKE LOWER(CONCAT('%', :symptom, '%'))")
    List<Disease> findBySymptomContaining(@Param("symptom") String symptom);
}
