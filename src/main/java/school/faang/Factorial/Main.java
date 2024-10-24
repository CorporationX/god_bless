package school.faang.Factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>
                (List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));

        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        futures.forEach(e -> e.thenAcceptAsync(result -> {
            counter.incrementAndGet();
            log.info(result.toString());
        }).join());

        log.info(String.valueOf(counter.get() == numbers.size()));
    }
}
