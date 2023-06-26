package faang.school.godbless.exception;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        Supplier<String> remoteServiceSupplier = () -> remoteService.call("some string");
        ExceptionHandler<String> exceptionHandler = Throwable::getMessage;

        String result = ExceptionProcessor.withErrorHandling(remoteServiceSupplier, exceptionHandler);

        System.out.println(result);
    }
}
