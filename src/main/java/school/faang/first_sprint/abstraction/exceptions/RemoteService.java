package school.faang.first_sprint.abstraction.exceptions;

public class RemoteService {
    public String call(String param) {
        throw new RuntimeException("Сервис недоступен");
    }
}
