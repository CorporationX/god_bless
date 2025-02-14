package school.faang.naughtwoBJS257668;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> action = () -> null;
        ExceptionTaker<String> exceptionTaker = e -> {
            System.out.println("Error calling service, returning default value");
            return "DEFAULT";
        };
        String string = withErrorHandling(action, exceptionTaker);
        System.out.println(string);

        String result = withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error calling service, returning default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionTaker<T> exceptionTaker) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionTaker.handling(e);
        }
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
