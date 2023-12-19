package org.atelier.cours.service;

import org.atelier.cours.core.Module;
import org.atelier.cours.exception.ResourceNotFoundException;
import org.atelier.cours.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Iterable<Module> getModules() {
        return  moduleRepository.findAll();
    }


    public Optional<Module> getModule(Integer id) {
        return moduleRepository.findById(id);
    }

   public void ajouterModule(Module module) {
       moduleRepository.save(module);

   }

    public void modifierModule(Integer id, Module module) {

        try{
            Optional<Module> moduleOptional = moduleRepository.findById(id);

            if (moduleOptional.isPresent()) {
                Module existingModule = moduleOptional.get();

                existingModule.setNom(module.getNom());
                existingModule.setDescription(module.getDescription());

                moduleRepository.save(existingModule);
            }

        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Module with ID " + id + " not found", e);
        }

    }

    public void supprimerModule(Integer id) {
        moduleRepository.deleteById(id);
    }

}
