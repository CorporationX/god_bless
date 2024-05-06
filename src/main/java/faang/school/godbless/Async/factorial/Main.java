package faang.school.godbless.Async.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static faang.school.godbless.Async.factorial.Factorial.factorialBig;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(
                50, 100, 200, 300, 400, 10, 25, 10000
        );
        List<CompletableFuture<BigInteger>> result = factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < result.size(); ++i) {
            int finalI = i;
            result.get(i).thenAcceptAsync((res) -> {
                System.out.println("Factorial of " + numbers.get(finalI) + " is: " + res);
                counter.incrementAndGet();
            });
        }


        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        List<CompletableFuture<BigInteger>> results = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); ++i) {
            int finalI = i;
            CompletableFuture<BigInteger> result = CompletableFuture.supplyAsync(
                    () -> factorialBig(numbers.get(finalI))
            );
            results.add(result);
        }

        return results;
    }

}
