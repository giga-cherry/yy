package ru.itis.mapper;

import ru.itis.api.dto.response.TokenResponse;
import ru.itis.model.TokenEntity;

public class TokenMapperImpl implements TokenMapper{
    @Override
    public TokenEntity toTokenEntity(TokenResponse token) {
        return TokenEntity.builder()
                .token(token.getToken())
                .build();
    }

    @Override
    public TokenResponse toTokenResponse(TokenEntity token) {
        return TokenResponse.builder()
                .token(token.getToken())
                .build();
    }
}
