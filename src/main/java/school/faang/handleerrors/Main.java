package school.faang.handleerrors;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("something");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                },
                e -> {
                    System.out.println("Error calling service, returning default value");
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
