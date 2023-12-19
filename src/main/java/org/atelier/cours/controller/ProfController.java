package org.atelier.cours.controller;

import org.atelier.cours.core.Cours;
import org.atelier.cours.core.Professeur;
import org.atelier.cours.service.CoursService;
import org.atelier.cours.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfController {

    @Autowired
    private CoursService coursService;
    @Autowired
    private ProfService profService;

    @GetMapping
    public List<Professeur> getAllProf(){
        return profService.getAllProfessor();
    }
    @GetMapping("/{id}/cours")
    public List<Cours> getAllCoursOfProf(@PathVariable Integer id){
        return coursService.getAllCoursOfProf(id);
    }
    @GetMapping("/{id}")
    public Optional<Professeur> getProf(@PathVariable Integer id){
        return profService.getProf(id);
    }

    @PostMapping("/{profId}/cours")
    public void ajouterCours(@RequestBody Cours cours, @PathVariable Integer profId) {
        cours.setProf(new Professeur(profId, "", ""));
        coursService.ajouterCours(cours);
    }
    @PutMapping("/{profId}/cours/{id}")
    public void modifierCours(@RequestBody Cours cours, @PathVariable Integer profId,
                              @PathVariable Integer id) {
        cours.setProf(new Professeur(profId,"",""));
        coursService.modifierCours(cours,id);
    }
    @DeleteMapping("/{profId}/cours/{id}")
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }

}
