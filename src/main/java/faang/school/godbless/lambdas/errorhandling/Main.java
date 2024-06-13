package faang.school.godbless.lambdas.errorhandling;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();

        System.out.println(
                withErrorHandling(remoteService::call, Throwable::getMessage));
        System.out.println(
                withErrorHandling(remoteService::callWithException, Throwable::getMessage));

        System.out.println(
                withErrorHandling(123, remoteService::call, Throwable::getMessage));
        System.out.println(
                withErrorHandling(123, remoteService::callWithException, Throwable::getMessage));
    }

    public static <K, T> T withErrorHandling(K param, Function<K, T> action,
                                             ExceptionHandler<T> handler) {
        try {
            return action.apply(param);
        } catch (Exception e) {
            return handler.handle(e);
        }
    }

    public static <T> T withErrorHandling(Supplier<T> action,
                                          ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }

    private static class RemoteService {
        private String call() {
            return "Заглушка";
        }

        private String call(Integer i) {
            return "Заглушка + " + i;
        }

        private String callWithException() {
            throw new RuntimeException("Эксеншен");
        }

        private String callWithException(Integer i) {
            return "Эксеншен + " + i;
        }
    }
}
