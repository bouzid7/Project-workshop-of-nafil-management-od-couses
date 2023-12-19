package org.atelier.cours.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

@Entity
public class Cours {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String description;
    @ManyToOne
    private Module module;

    @ManyToOne
    private Professeur prof;

    public Cours(Integer id, String nom, String description, Integer moduleId,Integer profId) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.module = new Module(moduleId,"","");
        this.prof=new Professeur(profId,"","");
    }
    public Cours() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
   public Professeur getProf(){
        return prof;
   }
    public void setProf(Professeur prof) {
        this.prof = prof;
    }
}
