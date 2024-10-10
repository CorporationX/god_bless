package ErrorsHandler;

@FunctionalInterface
public interface ActionWithException<T> {
     T execute() throws Exception;
}
