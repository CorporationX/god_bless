package faang.school.godbless.lambda.errors;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.callException("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке


        // Пример с вызовом удалённого сервиса
        String result2 = ErrorHandler.withErrorHandling(
                () -> RemoteService.callOk("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result2);  // Выведет результат: "OK"
    }

    public static class RemoteService {
        public static String callException(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }

        public static String callOk(String param) throws Exception {
            return "OK";
        }
    }

}
