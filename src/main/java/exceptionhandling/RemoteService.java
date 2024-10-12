package exceptionhandling;

public class RemoteService {
    public static String methodWithException() {
        throw new RuntimeException("Сервис недоступен");
    }

    public static String methodWithoutException() {
        return "Подключение произведено успешно";
    }
}
