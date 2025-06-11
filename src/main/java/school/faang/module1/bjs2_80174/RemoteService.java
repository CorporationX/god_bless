package school.faang.module1.bjs2_80174;

public class RemoteService {
    public static String call(String param) {
        if ("fail".equals(param)) {
            throw new RuntimeException("Сервис недоступен");
        }
        return "Результат для " + param;
    }
}