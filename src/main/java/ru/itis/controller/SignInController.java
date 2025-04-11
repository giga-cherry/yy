package ru.itis.controller;

import ru.itis.api.SignInApi;
import ru.itis.api.dto.request.SignInRequest;
import ru.itis.api.dto.response.TokenResponse;
import ru.itis.service.SignInService;

public class SignInController implements SignInApi {

    SignInService signInService;

    public SignInController(SignInService signInService){
        this.signInService=signInService;
    }

    @Override
    public TokenResponse signInByToken(SignInRequest request) {
        return signInService.signInByToken(request);
    }
}
