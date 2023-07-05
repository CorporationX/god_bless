package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static faang.school.godbless.factorial.Factorial.factorials;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 18, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> futuresFactorials = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < futuresFactorials.size(); i++) {
            CompletableFuture<BigInteger> future = futuresFactorials.get(i);
            int number = numbers.get(i);
            future.thenAccept(factorial -> {
                System.out.println("Factorial of " + number + ": " + factorial);
                counter.incrementAndGet();
            });
        }

        CompletableFuture<Void> allTasks =  CompletableFuture.allOf(futuresFactorials.toArray(CompletableFuture[]::new));

        allTasks.thenRun(() -> {
            System.out.println("Awaited all asynchronous tasks, counter = " + counter.get());
        });
    }
}
