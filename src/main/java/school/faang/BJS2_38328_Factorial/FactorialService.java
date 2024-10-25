package school.faang.BJS2_38328_Factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class FactorialService {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 5, 10, 12, 15, 19, 20);
        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                IntStream.range(0, futures.size())
                        .mapToObj(index -> futures.get(index)
                                .thenAccept(factorial -> log.info("Factorial of number {} is {}", numbers.get(index), factorial))
                        )
                        .toArray(CompletableFuture[]::new)
        );

        allFutures.join();
    }
}
