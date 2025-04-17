package school.faang.bjs270224;

public interface ErrorHandlerFunctionInterface {

    interface ErrorHandlerFunction<T> {
        T handle(Exception e);
    }
}
