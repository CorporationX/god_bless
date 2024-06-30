package faang.school.godbless.BJS29796.validator;

public interface Validator<T> {

    ValidationResult validate(T object);
}