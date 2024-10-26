package school.faang.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>
                (List.of(1, 4, 7, 13, 14, 15, 16, 17, 18, 19));

        List<CompletableFuture<BigInteger>> futures =
                Factorial.factorials(numbers);
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    IntStream.range(0, futures.size())
                            .forEach(e -> {
                                try {
                                    BigInteger res = futures.get(e).get();
                                    System.out.println("Factorial of " + numbers.get(e) + " is " + res);
                                } catch (InterruptedException |
                                         ExecutionException ex) {
                                    log.error("Error computing factorial", e);
                                    throw new RuntimeException(ex);
                                }
                            });
                    log.info("All done.");
                }).join();
    }
}
