package school.faang.errorhandling;

public class RemoteService {

    public static String call(String param) {
        // Здесь возникнет ошибка для демонстрации
        throw new RuntimeException("Сервис недоступен");
    }
}
