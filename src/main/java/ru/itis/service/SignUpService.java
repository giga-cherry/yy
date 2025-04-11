package ru.itis.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.api.dto.request.SignUpConfirmationRequest;
import ru.itis.api.dto.request.SignUpRequest;
import ru.itis.api.dto.response.OperationResponse;
import ru.itis.api.dto.response.TokenResponse;

public interface SignUpService {

    OperationResponse prepareSignUp(SignUpRequest request);

    TokenResponse confirmSignUp(SignUpConfirmationRequest request);
}
