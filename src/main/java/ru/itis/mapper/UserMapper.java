package ru.itis.mapper;

import ru.itis.api.dto.request.SignInRequest;
import ru.itis.api.dto.request.SignUpRequest;
import ru.itis.api.dto.response.TokenResponse;
import ru.itis.model.TokenEntity;
import ru.itis.model.UserEntity;

public interface UserMapper {

    UserEntity toUserEntity(SignInRequest token);

    UserEntity toUserEntity(SignUpRequest token);

    SignInRequest toSignInRequest(UserEntity token);
}
