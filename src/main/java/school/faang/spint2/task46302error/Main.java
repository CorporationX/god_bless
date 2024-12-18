package school.faang.spint2.task46302error;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}