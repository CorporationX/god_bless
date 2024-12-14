package school.faang.sprint2.bjs_46170;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
