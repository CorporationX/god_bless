package faang.school.godbless.handling_errors;

import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> {
            throw new IllegalArgumentException("Something went wrong!");
        };

        ExceptionHandler<String> errorHandling = exception -> {
            System.out.println("An exception occurred: " + exception.getMessage());
            return "Default Value";
        };

        String result = ExceptionUtil.withErrorHandling(supplier, errorHandling);
        System.out.println("Result: " + result);
    }
}
