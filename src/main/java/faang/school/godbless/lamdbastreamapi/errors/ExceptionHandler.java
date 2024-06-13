package faang.school.godbless.lamdbastreamapi.errors;

public interface ExceptionHandler<T> {
    T excetptionProcessor(Exception e);
}
