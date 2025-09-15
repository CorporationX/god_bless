package school.faang.bjs2_87593;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("SomeParam"),
                (e) -> {
                    System.out.println("Service is not started, returned default meaning");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}