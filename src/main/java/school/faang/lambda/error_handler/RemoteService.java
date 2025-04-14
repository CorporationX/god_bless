package school.faang.lambda.error_handler;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }
}
