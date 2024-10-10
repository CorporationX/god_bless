package school.faang.exceptionhandler;

public class Main {
    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandler();
        RemoteService remoteService = new RemoteService();

        String result = errorHandler.withErrorHandling(
                () -> {
                    try {
                        return remoteService.call("someParam");
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
}


