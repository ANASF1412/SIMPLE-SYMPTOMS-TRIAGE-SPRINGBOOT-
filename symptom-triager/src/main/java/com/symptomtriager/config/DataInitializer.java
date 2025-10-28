package com.symptomtriager.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.symptomtriager.model.Disease;
import com.symptomtriager.repository.DiseaseRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(DiseaseRepository diseaseRepository) {
        return args -> {
            if (diseaseRepository.count() == 0) {
                diseaseRepository.save(new Disease(
                    "Common Cold",
                    "runny nose, sneezing, cough, sore throat, mild fever",
                    "A viral infection of the upper respiratory tract"
                ));
                diseaseRepository.save(new Disease(
                    "Flu",
                    "fever, body aches, fatigue, cough, headache, chills",
                    "Influenza is a viral infection that attacks the respiratory system"
                ));
                diseaseRepository.save(new Disease(
                    "Migraine",
                    "severe headache, nausea, sensitivity to light, vomiting",
                    "A type of headache characterized by severe pain"
                ));
                diseaseRepository.save(new Disease(
                    "Food Poisoning",
                    "nausea, vomiting, diarrhea, stomach cramps, fever",
                    "Illness caused by eating contaminated food"
                ));
                diseaseRepository.save(new Disease(
                    "Allergic Reaction",
                    "rash, itching, swelling, difficulty breathing, hives",
                    "Body's immune response to allergens"
                ));
            }
        };
    }
}
