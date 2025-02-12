package school.faang.processererror;

@FunctionalInterface
public interface RunServer<T> {
    T run() throws Exception;
}
