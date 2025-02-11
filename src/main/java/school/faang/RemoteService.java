package school.faang;

public class RemoteService {
    public static String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }
}
