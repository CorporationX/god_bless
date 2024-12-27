package school.faang.task_50273;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 5, 23, 99999, 3, 11, 0);
        List<CompletableFuture<BigInteger>> futureFactorials = Factorial.factorials(numbers);

        CompletableFuture<Void> factorialsResult = CompletableFuture.allOf(
                futureFactorials.toArray(new CompletableFuture[0]));

        factorialsResult.join();
    }
}
