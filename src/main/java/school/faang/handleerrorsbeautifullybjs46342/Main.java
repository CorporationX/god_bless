package school.faang.handleerrorsbeautifullybjs46342;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Some param"),
                e -> {
                    System.out.println("Error when calling the service, we return the default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
