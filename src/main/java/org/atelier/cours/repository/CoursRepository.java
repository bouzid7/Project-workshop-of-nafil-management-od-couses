package org.atelier.cours.repository;

import java.util.List;
import org.atelier.cours.core.Cours;
import org.springframework.data.repository.CrudRepository;
public interface CoursRepository extends CrudRepository<Cours, Integer>{
     List<Cours> findByModuleId(Integer moduleId);
     List<Cours> findByProfId(Integer profId);

}