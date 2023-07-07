package factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static factorial.Factorial.factorials;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> result = factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < result.size(); ++i) {
            int index = i;
            new Thread(
                    () -> {
                        BigInteger factorial = result.get(index).join();
                        System.out.println("Factorial of " + numbers.get(index) + " is " + factorial);
                        counter.incrementAndGet();
                    }
            ).start();
        }

        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }
        System.out.println("Awaited all asynchronous tasks. Counter = " + awaitCounter);
    }
}
