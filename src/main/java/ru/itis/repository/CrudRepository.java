package ru.itis.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E, ID> {

    E save(E entity);

    void deleteById(ID id);

    List<E> findAll();

    Optional<E> findById(ID id);

}
