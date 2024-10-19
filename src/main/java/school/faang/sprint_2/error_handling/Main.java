package school.faang.sprint_2.error_handling;

import java.util.Random;

public class Main {
    static final int SERVICE_CHECKED = new Random().nextInt(2);

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            if (SERVICE_CHECKED > 0) {
                return "Сервис доступен с параметрами " + param;
            } else {
                throw new Exception("Сервис недоступен");
            }
        }
    }
}