package school.faang.task_50310;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static school.faang.task_50310.Factorial.factorials;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 12, 15, 20, 25);
        List<CompletableFuture<BigInteger>> futures = factorials(numbers);


        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> {
                    try {
                        System.out.println("Result " + future.join());
                    } catch (Exception e) {
                        System.err.println("Error during result processing: " + e.getMessage());
                    }
                }))
                .join();

        System.out.println("All task are ended");

    }
}
