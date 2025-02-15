package school.faang.errorhandling;

public class RemoteService {

    public static String call(String param) {
        throw new ServiceUnavailableException("Сервис недоступен");
    }
}
