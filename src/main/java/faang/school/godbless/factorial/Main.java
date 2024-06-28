package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = Factorial.factorials(numbers);

        AtomicInteger counter = new AtomicInteger();

        for (CompletableFuture<BigInteger> bigIntegerCompletableFuture : result) {
            new Thread(() -> {
                System.out.println(bigIntegerCompletableFuture.join());
                counter.incrementAndGet();
            }).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }

        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
        Factorial.closeFactorialCalculator();
    }
}
