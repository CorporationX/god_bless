package school.faang.exceptions;

public class RemoteService {
    public String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }
}
