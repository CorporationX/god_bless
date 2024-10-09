package school.faang.error_hending;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        Function<String, Object> supplier = param -> {
            try {
                return remoteService.call(param);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Consumer<String> consumer = error -> {System.out.println(error + " : здесь у вас ошибка");};

        ErrorHandler errorHandler = new ErrorHandler();
        Object result = errorHandler.withErrorHandling("http", consumer, supplier);
        System.out.println(result);
    }
}
