package ru.itis.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.api.dto.request.LogoutRequest;
import ru.itis.api.dto.response.OperationResponse;

public interface LogoutService {
    OperationResponse logout(LogoutRequest request);
}
