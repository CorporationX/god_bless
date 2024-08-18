package faang.school.godbless.BJS2_21200;

public class Main {
    private static final String DEFAULT_RESPONSE = "DEFAULT";

    public static void main(String[] args) {
        System.out.println("Полученные данные: " + callRemoteService("some_param"));
        System.out.println("Полученные данные: " + callRemoteService("error"));
    }

    static String callRemoteService(String param) {
        return ErrorHandlingClass.withErrorHandling(() -> remoteServiceCall(param), (exception) -> {
            System.err.println("Не удалось получить доступ к удаленному сервису: " + exception.getMessage());
            return DEFAULT_RESPONSE;
        });
    }

    private static String remoteServiceCall(String param) {
        if ("error".equals(param)) {
            throw new RuntimeException("Remote service error");
        }

        return "SUCCESS";
    }
}
