package school.faang.handlingerrorsbeautifully;

public class RemoteService {
    public static String call(String param) {
        // Здесь возникнет ошибка для демонстрации
        throw new RuntimeException("Сервис недоступен");
    }
}


