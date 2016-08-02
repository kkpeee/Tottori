package jp.co.tottori.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.tottori.validator.annotation.Memo;

public class MemoValidator implements ConstraintValidator<Memo, String> {

    public void initialize(Memo memo) {
    }

    public boolean isValid(String input, ConstraintValidatorContext con) {
        if (input == null) {
            return false;
        }
        if (input.matches("^[0-9]*$")) {
            return false;
        }
        return true;
    }
}