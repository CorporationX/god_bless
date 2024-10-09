package dima.evseenko.error;

public class RemoteService {
    public static String call(String param) throws Exception {
        if ("error".equals(param))
            throw new Exception("Сервис недоступен");
        return "calling %s successful".formatted(param);
    }
}