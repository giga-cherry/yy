package ru.itis.validator;

import java.util.Objects;

public class EmailValidatorImpl implements EmailValidator{
    public final String REGEX = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.[a-z]{2,4}";

    public boolean validate(String email) {
        return !Objects.isNull(email) && email.matches(REGEX);
    }
}
