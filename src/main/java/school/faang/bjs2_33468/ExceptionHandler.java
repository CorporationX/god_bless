package school.faang.bjs2_33468;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle() throws Exception;
}
