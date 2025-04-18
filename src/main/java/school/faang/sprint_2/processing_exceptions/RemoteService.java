package school.faang.sprint_2.processing_exceptions;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }
}
