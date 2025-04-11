package ru.itis.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.api.dto.request.SignInRequest;
import ru.itis.api.dto.response.TokenResponse;

public interface SignInService {

    TokenResponse signInByToken(SignInRequest request);

}
