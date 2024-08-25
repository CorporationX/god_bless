package faang.school.godbless.errors;

public class ErrorHandlingService {
    public static <T> String withErrorHandling(
            FunctionWithException<T, String> request, ExceptionHandler handler, T params
    ) {
        try {
            return request.apply(params);
        } catch (Exception e) {
            handler.handle(e);
            return "DEFAULT";
        }
    }

    public static void main(String[] args) {
        System.out.println(withErrorHandling(params -> {
            throw new IllegalAccessException();
        }, System.out::println, "params"));
        System.out.println(withErrorHandling(params -> "result", System.out::println, "params"));
    }
}
