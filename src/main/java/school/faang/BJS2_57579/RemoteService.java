package school.faang.BJS2_57579;

public class RemoteService {
    public static String call(String param) {
        if (param == null) {
            throw new RuntimeException("Сервис недоступен");
        } else {
            return param;
        }
    }
}
