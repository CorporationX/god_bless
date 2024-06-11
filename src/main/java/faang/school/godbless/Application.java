package faang.school.godbless;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        Supplier<String> example = () -> {
            int number = (int) (Math.random() * 2);
            if (number == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return Integer.toString(number);
        };
        System.out.println(ExceptionProcessor.withErrorHandling(example, (e) -> e.getMessage()));
    }
}