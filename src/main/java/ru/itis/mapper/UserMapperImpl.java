package ru.itis.mapper;

import ru.itis.api.dto.request.SignInRequest;
import ru.itis.api.dto.request.SignUpRequest;
import ru.itis.model.TokenEntity;
import ru.itis.model.UserEntity;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity toUserEntity(SignInRequest token) {
        return UserEntity.builder()
                .email(token.getEmail())
                .rawPassword(token.getRawPassword())
                .build();
    }

    @Override
    public UserEntity toUserEntity(SignUpRequest token) {
        return UserEntity.builder()
                .email(token.getEmail())
                .rawPassword(token.getRawPassword())
                .nickname(token.getNickName())
                .confirmed(false)
                .build();
    }

    @Override
    public SignInRequest toSignInRequest(UserEntity token) {
        return SignInRequest.builder()
                .email(token.getEmail())
                .rawPassword(token.getRawPassword())
                .build();
    }
}
