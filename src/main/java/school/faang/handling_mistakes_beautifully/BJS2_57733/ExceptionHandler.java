package school.faang.handling_mistakes_beautifully.BJS2_57733;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
