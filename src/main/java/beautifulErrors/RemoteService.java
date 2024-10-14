package beautifulErrors;

public class RemoteService {
    public String call(String param) {
        throw new IllegalStateException("Сервис недоступен");
    }
}
