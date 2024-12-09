package school.faang.sprint_2.task_46162;

public class Main {
    public static void main(String[] args) {
        String resultWithError = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("some param"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        String successResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.anotherCall("some param"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(resultWithError);
        System.out.println(successResult);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }

        public static String anotherCall(String param) {
            System.out.println("Сервис успешно ответил");
            return "some data";
        }
    }
}