package school.faang.lambda.error_handler;

public class RemoteService {
    public static String call() {
        throw new RuntimeException("Сервис недоступен");
    }
}
