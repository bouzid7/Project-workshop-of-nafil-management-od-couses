package org.atelier.cours.controller;

import org.atelier.cours.core.Cours;
import org.atelier.cours.core.Module;
import org.atelier.cours.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class CoursController {
    @Autowired
    private CoursService coursService;
    @GetMapping("/{id}/cours")
    public List<Cours> getAllCours(@PathVariable Integer id){
        return coursService.getAllCoursModule(id);
    }
    @GetMapping("/{moduleId}/cours/{id}")
    public Optional<Cours> getCours(@PathVariable Integer id){
        return coursService.getCours(id);
    }
    @PostMapping("/{moduleId}/cours")
    public void ajouterCours(@RequestBody Cours cours, @PathVariable Integer moduleId) {
        cours.setModule(new Module(moduleId, "", ""));
        coursService.ajouterCours(cours);
    }
    @PutMapping("/{moduleId}/cours/{id}")
    public void modifierCours(@RequestBody Cours cours, @PathVariable Integer moduleId,
                              @PathVariable Integer id) {
        cours.setModule(new Module(moduleId,"",""));
        coursService.modifierCours(cours,id);
    }
    @DeleteMapping("/{moduleId}/cours/{id}")
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}