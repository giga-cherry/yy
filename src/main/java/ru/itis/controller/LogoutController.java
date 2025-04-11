package ru.itis.controller;

import ru.itis.api.LogoutApi;
import ru.itis.api.dto.request.LogoutRequest;
import ru.itis.api.dto.response.OperationResponse;
import ru.itis.service.LogoutService;
import ru.itis.service.SignInService;

public class LogoutController implements LogoutApi {

    LogoutService logoutService;

    public LogoutController(LogoutService logoutService){
        this.logoutService =logoutService;
    }

    @Override
    public OperationResponse logout(LogoutRequest request) {
        return logoutService.logout(request);
    }
}
