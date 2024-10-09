package school.faang.beautifulexceptions;

import java.util.List;

public class TestClass {
    public static void main(String[] args) {

        List<String> params = List.of("Ok", "");

        for (String param : params) {
            String result = ErrorHandler.withErrorHandling(
                    () -> RemoteService.call(param),
                    e -> {
                        System.out.println(e.getMessage());
                        System.out.println("Call service error, return default value");
                        return "DEFAULT";
                    }
            );
            System.out.println(result);
            System.out.println();
        }
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            if (param.equalsIgnoreCase("Ok")) {
                return "Server is Ok";
            }
            throw new Exception("Service unavailable");
        }
    }
}
