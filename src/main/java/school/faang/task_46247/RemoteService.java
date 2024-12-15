package school.faang.task_46247;

public class RemoteService {
    public static String callNoException(String param) {
        // Здесь ошибки не будет
        return "Сервис работает нормально";
    }

    public static String callWithException(String param) throws Exception {
        // Здесь возникнет ошибка для демонстрации
        throw new Exception("Сервис недоступен");
    }
}
