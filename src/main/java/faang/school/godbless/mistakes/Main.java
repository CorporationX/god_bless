package faang.school.godbless.mistakes;

import java.util.function.Function;

public class Main <T> {
    public static void withErrorHandling(Function<String, String> callService, ExceptionHandler<String> exceptionHandler){
        RemoteService<String> remoteService = new RemoteService<String>();
        String paramOfService = "parametr";
        try {
            remoteService.call(callService.apply(paramOfService));
        } catch (Exception e){
            exceptionHandler.handWithException(paramOfService);
        }
    }
}
