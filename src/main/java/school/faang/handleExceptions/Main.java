package school.faang.handleExceptions;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("params");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Remote service errer");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Remote service error");
        }
    }
}
