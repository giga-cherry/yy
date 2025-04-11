package ru.itis.validator;

public class ConfirmationCodeValidatorImpl implements ConfirmationCodeValidator{
    public final String CODE = "1";

    public boolean validate(String code) {
        return CODE.equals(code);
    }
}
