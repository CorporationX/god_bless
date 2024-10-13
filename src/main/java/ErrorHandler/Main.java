package ErrorHandler;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("param");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                (exception) -> {
                    System.out.println("Error in handling. Returning the default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
