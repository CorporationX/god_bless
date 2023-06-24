package faang.school.godbless.sprint3.HandlingErrorsBeautifully;

public interface ExceptionHandler<T> {
    Exception act(T tmp);
}
