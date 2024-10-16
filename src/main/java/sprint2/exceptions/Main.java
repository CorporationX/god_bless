package sprint2.exceptions;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> remoteService.callException("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке

        String result2 = ErrorHandler.withErrorHandling(
                () -> remoteService.callGood("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result2);
    }

    public static class remoteService {
        public static String callException(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }

        public static String callGood(String param) throws Exception {
            return "All is good";
        }
    }


}

