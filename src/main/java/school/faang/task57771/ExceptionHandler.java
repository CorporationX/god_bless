package school.faang.task57771;

@FunctionalInterface
public interface ExceptionHandler<T, R> {
    R handleException(T t);
}
