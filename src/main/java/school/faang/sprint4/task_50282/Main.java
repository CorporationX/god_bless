package school.faang.sprint4.task_50282;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 100, 200, 300, 400, 10, 25, 10000);

        List<CompletableFuture<BigInteger>> future = Factorial.factorials(numbers);

        int taskCount = numbers.size();

        IntStream.range(0, taskCount)
                .forEach((i) -> {
                    new Thread(() -> {
                        BigInteger result = future.get(i).join();
                        log.info("Factorial for N = {} : {}", numbers.get(i), result);
                    }).start();
                });
    }
}
