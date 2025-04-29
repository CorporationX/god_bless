package school.faang.handingerrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
