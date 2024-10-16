package school.faang.BJS2_33602;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(

            // НЕ МОГУ ПОНЯТЬ В ЧЕМ ПРОБЛЕМА!!!!!!!!!
//            : error: unreported exception Exception; must be caught or declared to be thrown
//        () -> RemoteService.call("someParam"),  // Основное действие
//                                    ^

            () -> RemoteService.call("someParam"),  // Основное действие
            e -> {  // Обработка ошибки
                System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                return "DEFAULT";
            }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке
    }

    // Пример метода для удалённого сервиса
    public static class RemoteService {
        public static String call(String param) throws Exception {
            // Здесь возникнет ошибка для демонстрации
            throw new Exception("Сервис недоступен");
        }
    }
}
