package school.faang.processorerror;

@FunctionalInterface
public interface BaseAction<T> {
    T execute() throws Exception;
}
