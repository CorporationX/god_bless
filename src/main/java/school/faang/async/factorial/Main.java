package school.faang.async.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 13, 200, 300, 400, 10, 25, 10000);

        List<CompletableFuture<BigInteger>> futureFactorials = Factorial.calcFactorials(numbers);

        AtomicInteger counter = new AtomicInteger(0);

        IntStream
                .range(0, numbers.size())
                .forEach((idx) ->
                        new Thread(() -> {
                            BigInteger result = futureFactorials.get(idx).join();
                            log.info("Factorial of {} equals {}", numbers.get(idx), result);
                            counter.incrementAndGet();
                        }).start());

        Instant start = Instant.now();
        while (counter.get() != numbers.size()) {}
        Instant end = Instant.now();
        Duration dur = Duration.between(start, end);

        log.info("All async tasks were completed. Calculation finished in {} ms", dur.toMillis());
    }
}
