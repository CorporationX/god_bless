package exceptionhandling;

public class Main {
    public static void main(String[] args) {
        String resultWithException = ErrorHandler.withErrorHandling(
                () -> RemoteService.methodWithException(),
                e -> {
                    System.out.println("Ошибка " + e.getMessage());
                    return "что-то пошло не так";
                });
        System.out.println(resultWithException);

        String resultWithoutException = ErrorHandler.withErrorHandling(
                () -> RemoteService.methodWithoutException(),
                e -> {
                    System.out.println("Ошибка " + e.getMessage());
                    return "что-то опять пошло не так";
                }
        );
        System.out.println(resultWithoutException);
    }
}
