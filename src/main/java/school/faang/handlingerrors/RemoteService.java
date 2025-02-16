package school.faang.handlingerrors;

public class RemoteService {
    public static String call(String param) {
        if (param.equals("someParam")) {
            throw new RuntimeException("Сервис недоступен");
        }
        return "Сервер вызван успешно";
    }
}