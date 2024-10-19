package school.faang.BJS2_33565;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    System.out.println("e.getMessage():" + e.getMessage());
                    return "DEFAULT";

                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
//            System.out.println("Remote service called");
            throw new Exception("Сервис недоступен");
        }
    }
}