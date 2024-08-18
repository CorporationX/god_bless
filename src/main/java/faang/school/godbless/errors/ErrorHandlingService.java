package faang.school.godbless.errors;

public class ErrorHandlingService {
    public static <T> String withErrorHandling(
            FunctionWithException<T, String> request,
            ExceptionHandler handler,
            T params
    ) {
        try {
            return request.apply(params);
        } catch (Exception e) {
            handler.handle(e);
            return "DEFAULT";
        }
    }

    private static String faultyRequest(String params) throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    private static String correctRequest(String params) {
        return "result";
    }


    public static void main(String[] args) {
        ExceptionHandler exceptionHandler = System.out::println;
        System.out.println(withErrorHandling(ErrorHandlingService::faultyRequest, exceptionHandler, "params"));
        System.out.println(withErrorHandling(ErrorHandlingService::correctRequest, exceptionHandler, "params"));
    }
}
