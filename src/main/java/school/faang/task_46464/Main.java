package school.faang.task_46464;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () ->  RemoteService.call("someParam"),
                e -> {
                    System.out.println("The error occurred while calling the service, returning the default value.");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("The service is unavailable.");
        }
    }
}
