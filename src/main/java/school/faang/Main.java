package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 30).boxed().toList();
        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

        futures.forEach(num -> {
            try {
                System.out.println(num.get());
            } catch (InterruptedException | ExecutionException e) {
                log.error("Error while getting CompletableFuture result.");
                Thread.currentThread().interrupt();
            }
        });
    }
}
