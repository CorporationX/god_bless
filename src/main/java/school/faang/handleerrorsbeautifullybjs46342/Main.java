package school.faang.handleerrorsbeautifullybjs46342;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("Some param");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Error when calling the service, we return the default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
