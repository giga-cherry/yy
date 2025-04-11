package ru.itis.controller;

import ru.itis.api.SignUpApi;
import ru.itis.api.dto.request.SignUpConfirmationRequest;
import ru.itis.api.dto.request.SignUpRequest;
import ru.itis.api.dto.response.OperationResponse;
import ru.itis.api.dto.response.TokenResponse;
import ru.itis.service.SignInService;
import ru.itis.service.SignUpService;

public class SignUpController implements SignUpApi {

    SignUpService signUpService;

    public SignUpController(SignUpService signUpService){
        this.signUpService=signUpService;
    }

    @Override
    public OperationResponse prepareSignUp(SignUpRequest request) {
        return signUpService.prepareSignUp(request);
    }

    @Override
    public TokenResponse confirmSignUp(SignUpConfirmationRequest request) {
        return signUpService.confirmSignUp(request);
    }
}
