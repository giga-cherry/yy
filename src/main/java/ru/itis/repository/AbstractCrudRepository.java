package ru.itis.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

abstract public class AbstractCrudRepository <E, ID> implements CrudRepository<E, ID> {

    protected final EntityManager entityManager;

    protected AbstractCrudRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public E save(E entity) {
        EntityTransaction transaction = transactionBegin();

        entityManager.persist(entity);

        transaction.commit();
        return entity;
    }

    @Override
    public void deleteById(ID id) {
        EntityTransaction transaction = transactionBegin();

        E entity = findByIdNotNull(id);
        entityManager.remove(entity);

        transaction.commit();
    }

    protected E findByIdNotNull(ID id){
        Optional<E> entity = findById(id);
        if(entity.isEmpty()) {
            throw new IllegalArgumentException("Entity id " + id + " not found!");
        }
        else{
            return entity.get();
        }
    }

    protected EntityTransaction transactionBegin(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        return transaction;
    }

    @Override
    public List<E> findAll() {
        EntityTransaction transaction = transactionBegin();

        TypedQuery<E> query = entityManager.createQuery(getSelectAll(), getEntityClass());
        List<E> result = query.getResultList();

        transaction.commit();
        return result;
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    public abstract Class<E> getEntityClass();
    public abstract String getSelectAll();
}
