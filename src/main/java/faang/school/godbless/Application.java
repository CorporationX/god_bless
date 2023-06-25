package faang.school.godbless;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Application {
    public static void main(String... args) {
       RemoteService remoteService = new RemoteService();
       String res = withErrorHandling(() -> remoteService.call(""), Throwable::getMessage);
       System.out.println(res);
    }

    static<T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return  action.get();
        } catch (Exception ex) {
            return onError.handle(ex);
        }
    }
}
