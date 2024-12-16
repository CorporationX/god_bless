package school.faang.errorhandling;

public class Main {
    public static void main(String[] args) throws Exception {
        String result = callRemoteService("some text");
        System.out.println("success case:" + result);
        String errResult = callRemoteService("error");
        System.out.println("Error case:" + errResult);
    }

    private static String callRemoteService(String param) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call(param), e -> {
                    System.out.println("Error calling service, returning default value");
                    return "DEFAULT";
                });
        return result;
    }
}
