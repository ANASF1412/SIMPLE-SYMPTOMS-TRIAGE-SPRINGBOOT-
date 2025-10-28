package com.symptomtriager.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symptomtriager.model.Disease;
import com.symptomtriager.repository.DiseaseRepository;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    public List<Disease> findBySymptoms(String symptoms) {
        if (symptoms == null || symptoms.isBlank()) {
            return Collections.emptyList();
        }
        String[] symptomArray = symptoms.toLowerCase().split(",");
        Set<Disease> matchingDiseases = new HashSet<>();

        for (String symptom : symptomArray) {
            String s = symptom.trim();
            if (!s.isEmpty()) {
                List<Disease> diseases = diseaseRepository.findBySymptomContaining(s);
                matchingDiseases.addAll(diseases);
            }
        }

        return new ArrayList<>(matchingDiseases);
    }

    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    public Disease save(Disease disease) {
        return diseaseRepository.save(disease);
    }

    public void deleteById(Long id) {
        diseaseRepository.deleteById(id);
    }

    public Disease findById(Long id) {
        return diseaseRepository.findById(id).orElse(null);
    }
}
