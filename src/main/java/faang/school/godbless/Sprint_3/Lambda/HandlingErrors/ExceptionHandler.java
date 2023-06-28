package faang.school.godbless.Sprint_3.Lambda.HandlingErrors;

public interface ExceptionHandler<T> {
    T exception(Exception e);
}
