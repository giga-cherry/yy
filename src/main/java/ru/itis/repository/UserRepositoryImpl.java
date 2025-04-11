package ru.itis.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itis.model.UserEntity;
import ru.itis.model.TokenEntity;

import java.util.Objects;

public class UserRepositoryImpl extends AbstractCrudRepository<UserEntity,Long> implements UserRepository {
    SessionFactory sessionFactory;
    private static final String SELECT_BY_LOGIN = "select user from UserEntity user where user.email = :email";

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }


    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public String getSelectAll() {
        return null;
    }

    @Override
    public UserEntity findByLogin(String email) {
        EntityTransaction transaction = transactionBegin();

        TypedQuery<UserEntity> query = entityManager.createQuery(SELECT_BY_LOGIN, UserEntity.class);
        query.setParameter("email", email);

        try {
            UserEntity ue = query.getSingleResult();
            return ue;
        } catch (NoResultException e) {
            return null;
        } finally {
            transaction.commit();
        }
    }

    @Override
    public UserEntity updateById(UserEntity entity, Long id) {
        EntityTransaction transaction = transactionBegin();

        UserEntity user = findByIdNotNull(id);
        user.setEmail(entity.getEmail());
        user.setNickname(entity.getNickname());
        user.setRawPassword(entity.getRawPassword());
        user.setConfirmed(entity.isConfirmed());

        transaction.commit();
        return user;
    }

    @Override
    public void confirmUser(long id) {
        UserEntity ue = findByIdNotNull(id);

        ue.setConfirmed(true);

        updateById(ue, id);
    }
}
