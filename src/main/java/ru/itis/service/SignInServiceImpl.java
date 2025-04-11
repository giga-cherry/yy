package ru.itis.service;

import ru.itis.api.dto.request.SignInRequest;
import ru.itis.api.dto.response.TokenResponse;
import ru.itis.mapper.TokenMapper;
import ru.itis.mapper.UserMapper;
import ru.itis.repository.UserRepository;

import java.util.Objects;

public class SignInServiceImpl implements SignInService{

    UserRepository userRepository;
    UserMapper userMapper;

    public SignInServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository =userRepository;
        this.userMapper=userMapper;
    }

    @Override
    public TokenResponse signInByToken(SignInRequest request) {
        TokenResponse token = new TokenResponse();

        try {
            if (request.getEmail() == null) {
                token.setToken("3");
            } else if (request.getRawPassword() == null) {
                token.setToken("4");
            } else if (userRepository.findByLogin(request.getEmail()) == null) {
                token.setToken("1");
            } else if (!Objects.equals(userRepository.findByLogin(request.getEmail()).getRawPassword(), request.getRawPassword())) {
                token.setToken("2");
            } else {
                token.setToken("0");
            }
            return token;
        }
        catch (Exception e){
            token.setToken("99");
            return token;
        }
    }
}
