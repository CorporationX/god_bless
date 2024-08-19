package faang.school.godbless.handling_errors;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        String retrievedValue = withErrorHandling(
                () -> serviceCall("http://www.google.com", () -> "{ name: 'William', surname: 'Butcher', age: 47 }"),
                e -> {
                    System.out.println("Something has gone wrong during the call...");
                    return "{ name: null', surname: null, age: null }";
                }
        );
        System.out.println("Retrieved value: " + retrievedValue);
    }

    public static <T> T withErrorHandling(Callable<T> action, ExceptionHandler<T> handler) {
        try {
            return action.call();
        } catch(Exception e) {
            return handler.handle(e);
        }
    }

    public static <T> T serviceCall(String url, Supplier<T> returnAction) throws Exception {
        System.out.println("Making a network call to " + url + "...");
        int random = (int)(Math.random() * 4) + 1;
        if (random <= 2) {
            throw new Exception();
        }
        return returnAction.get();
    }
}
