package faang.school.godbless.handlingerrorsbeautifully2590;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
