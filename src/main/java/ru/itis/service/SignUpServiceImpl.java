package ru.itis.service;

import ru.itis.api.dto.request.SignUpConfirmationRequest;
import ru.itis.api.dto.request.SignUpRequest;
import ru.itis.api.dto.response.OperationResponse;
import ru.itis.api.dto.response.TokenResponse;
import ru.itis.mapper.UserMapper;
import ru.itis.repository.UserRepository;
import ru.itis.validator.ConfirmationCodeValidator;
import ru.itis.validator.ConfirmationCodeValidatorImpl;
import ru.itis.validator.EmailValidator;
import ru.itis.validator.PasswordValidator;

public class SignUpServiceImpl implements SignUpService{

    UserRepository userRepository;
    UserMapper userMapper;
    ConfirmationCodeValidator confirmationCodeValidator;
    EmailValidator emailValidator;
    PasswordValidator passwordValidator;

    public SignUpServiceImpl(UserRepository userRepository, UserMapper userMapper, EmailValidator emailValidator,
                             ConfirmationCodeValidator confirmationCodeValidator, PasswordValidator passwordValidator) {
        this.userRepository =userRepository;
        this.userMapper=userMapper;
        this.emailValidator = emailValidator;
        this.confirmationCodeValidator=confirmationCodeValidator;
        this.passwordValidator=passwordValidator;
    }


    @Override
    public OperationResponse prepareSignUp(SignUpRequest request) {
        TokenResponse token = new TokenResponse();

        try {
            if (request.getEmail() == null) {
                token.setToken("4");
            } else if (emailValidator.validate(request.getEmail())) {
                token.setToken("1");
            } else if (userRepository.findByLogin(request.getEmail()) != null) {
                token.setToken("2");
            } else if (request.getRawPassword()==null) {
                token.setToken("5");
            } else if (passwordValidator.validate(request.getRawPassword())) {
                token.setToken("3");
            }else {
                token.setToken("0");
//                отправить проверочный код на емейл
                userRepository.save(userMapper.toUserEntity(request));
            }
            return token;
        }
        catch (Exception e){
            token.setToken("99");
            return token;
        }
    }

    @Override
    public TokenResponse confirmSignUp(SignUpConfirmationRequest request) {
        TokenResponse token = new TokenResponse();

        try {
            if (request.getEmail() == null) {
                token.setToken("4");
            } else if (emailValidator.validate(request.getEmail())) {
                token.setToken("1");
            } else if (userRepository.findByLogin(request.getEmail()).isConfirmed()) {
                token.setToken("3");
            } else if (request.getConfirmCode()==null) {
                token.setToken("5");
            } else if (confirmationCodeValidator.validate(request.getConfirmCode())) {
                token.setToken("6");
            }else {
                token.setToken("0");
                userRepository.confirmUser(userRepository.findByLogin(request.getEmail()).getId());
            }
            return token;
        }
        catch (Exception e){
            token.setToken("99");
            return token;
        }
    }
}
