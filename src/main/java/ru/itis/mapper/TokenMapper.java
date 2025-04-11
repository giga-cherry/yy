package ru.itis.mapper;

import ru.itis.api.dto.response.TokenResponse;
import ru.itis.model.TokenEntity;

//не используется просто на всякий
public interface TokenMapper {

    TokenEntity toTokenEntity(TokenResponse token);

    TokenResponse toTokenResponse(TokenEntity token);
}
