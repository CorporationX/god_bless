package school.faang.errors.handling;

public class RemoteService {
    public static String call(String param) throws Exception {
        throw new Exception("Сервис недоступен");
    }
}
