package faang.school.godbless.r_edzie.lambdas.errors;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(withErrorHandling(Main::remoteService, Throwable::getMessage));
        System.out.println(withErrorHandling(Main::errorRemoteService, Throwable::getMessage));
    }


    public static String remoteService() {
        return "Ok";
    }

    public static String errorRemoteService() {
        throw new NoSuchElementException("Error");
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception exception) {
            return onError.handle(exception);
        }
    }
}
