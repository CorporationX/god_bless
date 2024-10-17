package module_2.module_2_1_Lambda.handlerErrorsNice;


public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling (
                () -> RemoteService.call("sameParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращая дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}
