package faang.school.godbless.Sprint_3.HandlingErrors;

public interface ExceptionHandler<T> {
    T exception(Exception e);
}
