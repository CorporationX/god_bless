package faang.school.godbless.BJS2_5330;

@FunctionalInterface
public interface ExceptionHandler<T, E extends Exception> {
    void accept(T t) throws E;
}
