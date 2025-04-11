package ru.itis.validator;

import java.util.Objects;

public class PasswordValidatorImpl implements PasswordValidator {

    public final String REGEX = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,40}";

    @Override
    public boolean validate(String password) {
        return !Objects.isNull(password) && password.matches(REGEX);
    }
}
