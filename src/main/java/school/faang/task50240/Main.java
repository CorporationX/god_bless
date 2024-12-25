package school.faang.task50240;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    private static final int LAST_FACTORIAL_NUMBER = 100;

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(-100, LAST_FACTORIAL_NUMBER).boxed().toList();
        Factorial factorial = new Factorial();

        CompletableFuture.allOf(factorial.factorials(numbers).toArray(CompletableFuture[]::new))
                .join();
    }
}
