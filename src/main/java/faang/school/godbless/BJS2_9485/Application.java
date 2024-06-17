package faang.school.godbless.BJS2_9485;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Application {

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        withErrorHandler(() -> remoteService.call("Hello"), e -> remoteService.getException());
        withErrorHandler(() -> remoteService.call(""), e -> remoteService.getException());
    }

    public static <T> T withErrorHandler(Supplier<T> method, ExceptionHandler<T> exception) {
        T obj;
        try {
            obj = method.get();
        } catch (Exception e) {
            obj = exception.handle(e);
            log.warn("It hasn't been possible to take the connection to Remote Service. The default value will be returned");
            T errMsg = (T) ("DEFAULT" + " | exception caused by " + ((Exception) obj).getMessage());
            System.out.println(errMsg);
        }
        return obj;
    }
}