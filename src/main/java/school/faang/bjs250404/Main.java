package school.faang.bjs250404;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(0, 5, 15, 20);
        List<CompletableFuture<BigInteger>> completableFutures = Factorial.factorialFutures(numbers);

        int numbersAmount = numbers.size();

        IntStream.range(0, numbersAmount)
                .forEach(i -> new Thread(() -> {
                    BigInteger result = completableFutures.get(i).join();
                    log.info("Factorial of number {} is {}", numbers.get(i), result);
                }).start());
    }
}