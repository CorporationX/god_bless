package school.faang.greatandterriblefactorial;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class FactorialMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 13, 20, 25);
        List<CompletableFuture<BigInteger>> futureFactorials = FactorialCalculator.calculateFactorials(numbers);

        AtomicInteger completedCount = new AtomicInteger(0);

        futureFactorials.forEach(future -> future.thenAccept(result -> {
            completedCount.incrementAndGet();
            System.out.println("Factorial calculated: " + result);
        }));

        while (completedCount.get() < futureFactorials.size()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All factorials have been calculated.");
    }
}
