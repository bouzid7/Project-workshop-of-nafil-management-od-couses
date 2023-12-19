package org.atelier.cours.controller;

import org.atelier.cours.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.atelier.cours.core.Module;
import java.util.Optional;


@RestController
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
     @GetMapping
     public Iterable<Module> getModules() {
         return moduleService.getModules();
     }

    @GetMapping("/{id}")
    public Optional<Module> getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    @PostMapping
    public void ajouterModule(@RequestBody Module module) {
         moduleService.ajouterModule(module);
    }

    @PutMapping("/{id}")
    public void modifierModule(@RequestBody Module module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
    }

    @DeleteMapping("/{id}")
    public void supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
    }

}