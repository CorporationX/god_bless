package school.faang.process.exception.beautiful;

import lombok.SneakyThrows;

public class RemoteService {
    @SneakyThrows
    public static String call(String param) {
        return param;
    }

    @SneakyThrows
    public static String callWithErrors(String param) {
        throw new Exception("Сервис недоступен");
    }
}
