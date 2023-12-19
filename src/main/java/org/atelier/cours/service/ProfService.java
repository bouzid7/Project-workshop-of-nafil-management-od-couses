package org.atelier.cours.service;

import org.atelier.cours.core.Cours;
import org.atelier.cours.core.Professeur;
import org.atelier.cours.exception.ResourceNotFoundException;
import org.atelier.cours.repository.CoursRepository;
import org.atelier.cours.repository.ProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfService {
    @Autowired
    private ProfRepository profRepository;
    @Autowired
    private CoursRepository coursRepository;
    public List<Professeur> getAllProfessor() {
         return profRepository.findAll();

    }
    public Optional<Professeur> getProf(Integer id) {
        return profRepository.findById(id);
    }
    public void ajouterProf(Professeur prof) {
        profRepository.save(prof);
    }
    public void modifierProf(Professeur prof,Integer id) {
        try{
            Optional<Professeur> profOptional = profRepository.findById(id);

            if (profOptional.isPresent()) {
                Professeur existingprof = profOptional.get();

                existingprof.setNom(prof.getNom());
                existingprof.setPrenom(prof.getPrenom());

                profRepository.save(existingprof);
            }

        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "prof with ID " + id + " not found", e);
        }

    }
    public void supprimerProf(Integer id) {
        profRepository.deleteById(id);
    }

}
