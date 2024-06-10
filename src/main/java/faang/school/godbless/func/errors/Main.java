package faang.school.godbless.func.errors;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<String> randomAction = () -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("You're unlucky!");
            }
            return "Success";
        };
        String result = ErrorHandling.withErrorHandling(randomAction, (e) -> "Fallback result because of: " + e.getMessage());
        System.out.println(result);
        String noSupplier = ErrorHandling.withErrorHandling(null, (e) -> "Fallback result because of: " + e.getMessage());
        System.out.println(noSupplier);
    }
}
