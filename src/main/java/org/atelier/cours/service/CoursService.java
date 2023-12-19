package org.atelier.cours.service;

import org.atelier.cours.core.Cours;
import org.atelier.cours.exception.ResourceNotFoundException;
import org.atelier.cours.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;
    public List<Cours> getAllCoursModule(Integer moduleId) {
        List<Cours> cours=new ArrayList<>();
        coursRepository.findByModuleId(moduleId).forEach(cours::add);
        return cours;
    }
    public List<Cours> getAllCoursOfProf(Integer profId) {
        List<Cours> cours=new ArrayList<>();
        coursRepository.findByProfId(profId).forEach(cours::add);
        return cours;
    }

    public Optional<Cours> getCours(Integer id) {
        return coursRepository.findById(id);
    }
    public void ajouterCours(Cours cours) {
        coursRepository.save(cours);
    }
    public void modifierCours(Cours cours,Integer id) {
        try{
            Optional<Cours> coursOptional = coursRepository.findById(id);

            if (coursOptional.isPresent()) {
                Cours existingcours = coursOptional.get();

                existingcours.setNom(cours.getNom());
                existingcours.setDescription(cours.getDescription());

                coursRepository.save(existingcours);
            }

        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cours with ID " + id + " not found", e);
        }

    }
    public void supprimerCours(Integer id) {
        coursRepository.deleteById(id);
    }
}