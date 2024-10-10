package school.faang.error_hending;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main<T extends Object> {
    public static <T> void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        Function<String, T> supplier = param -> {
            try {
                return remoteService.call(param);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Consumer<Exception> consumer = error -> {System.out.println(error + " : здесь у вас ошибка");};

        T result = ErrorHandler.withErrorHandling("http://faang-school.com", consumer, supplier);
        System.out.println(result);
    }
}
