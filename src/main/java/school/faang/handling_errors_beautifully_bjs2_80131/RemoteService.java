package school.faang.handling_errors_beautifully_bjs2_80131;

public class RemoteService {
    public static <T> T call(String message) {
        throw new RuntimeException("Сервис недоступен");
    }
}
