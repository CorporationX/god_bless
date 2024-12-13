package school.faang.spring2.task_46211;

import lombok.SneakyThrows;

public class Main {
    public static void main(String[] args) {

        String result = ErrorHandler.withErrorHandling(
                () ->  RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение "
                            + e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            if (param.length() < 10) {
                return "success";
            }
            throw new Exception("Сервис недоступен");
        }
    }
}
