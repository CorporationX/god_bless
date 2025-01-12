package school.faang.task_44808.common.validator;

@FunctionalInterface
public interface Validator<T> {
    void validate(T object);
}
