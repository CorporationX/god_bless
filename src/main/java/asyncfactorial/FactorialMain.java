package asyncfactorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class FactorialMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 12, 15, 20, 25);

        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

        futures.forEach(future -> future.thenAccept(result ->
                log.info("Factorial computed: {}", result)
        ));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        log.info("All factorials computed.");
    }
}
