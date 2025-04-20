package school.faang.sprinttwo.handleerrorsbeautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exp);
}