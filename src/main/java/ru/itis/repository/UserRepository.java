package ru.itis.repository;

import ru.itis.model.UserEntity;
import ru.itis.model.TokenEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

    UserEntity findByLogin(String email);

    void confirmUser(long id);

    UserEntity updateById(UserEntity entity, Long id);

}
