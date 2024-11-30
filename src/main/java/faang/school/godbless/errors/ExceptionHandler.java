package faang.school.godbless.errors;
@FunctionalInterface

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
