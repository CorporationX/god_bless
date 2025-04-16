package school.faang.errors_handling;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> callRemoteService,
                                          Function<Throwable, T> exceptionHandlerFunction) {
        T methodOutput;
        try {
            methodOutput = callRemoteService.get();
        } catch (Throwable e) {
            log.warn("remote service threw exception with message {}", e.getMessage());
            return exceptionHandlerFunction.apply(e);
        }
        return methodOutput;
    }

    public static <T> T externalService(T methodParam) {
        //method logic
        throw new RuntimeException("exception to check the second handler");
    }
}
