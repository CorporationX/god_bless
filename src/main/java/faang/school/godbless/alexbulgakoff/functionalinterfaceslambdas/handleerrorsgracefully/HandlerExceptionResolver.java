package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.handleerrorsgracefully;

import java.util.concurrent.Callable;

/**
 * @author Alexander Bulgakov
 */

public class HandlerExceptionResolver {

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService(0);

        System.out.println(withErrorHandling(
                () -> remoteService.call(remoteService.getStatus()),
                Throwable::getMessage));

    }

    public static <T> T withErrorHandling(Callable<T> caller, ExceptionHandler<T> handler) {
        try {
            return caller.call();
        } catch (Exception e) {
            return handler.handle(new Exception());
        }
    }
}
