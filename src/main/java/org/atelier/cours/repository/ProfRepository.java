package org.atelier.cours.repository;

import org.atelier.cours.core.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfRepository extends JpaRepository<Professeur,Integer> {


    Optional<Professeur> findById(Integer id);
}

    /*
    @Override
    public void flush() {

    }

    @Override
    public <S extends Integer> S saveAndFlush(S entity) {
        return null;}

    @Override
    public <S extends Integer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Integer> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Professeur> professeurs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Integer getOne(Professeur professeur) {
        return null;
    }

    @Override
    public Integer getById(Professeur professeur) {
        return null;
    }

    @Override
    public Integer getReferenceById(Professeur professeur) {
        return null;
    }

    @Override
    public <S extends Integer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Integer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Integer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Integer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Integer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Integer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Integer> findById(Professeur professeur) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Professeur professeur) {
        return false;
    }

    @Override
    public List<Integer> findAll() {
        return null;
    }

    @Override
    public List<Integer> findAllById(Iterable<Professeur> professeurs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Professeur professeur) {

    }

    @Override
    public void delete(Integer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Professeur> professeurs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Integer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Integer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Integer> findAll(Pageable pageable) {
        return null;
    }

     */

