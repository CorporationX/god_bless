package school.faang.sprint_4.task_50250;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(500, 100, 2, 3, 400, 600);
        AtomicInteger noCalculatedFactorialsCount = new AtomicInteger(numbers.size());

        List<CompletableFuture<BigInteger>> factorialsFutures = Factorial.factorials(numbers);

        for (int i = 0; i < factorialsFutures.size(); i++) {
            int finalI = i;
            factorialsFutures.get(i).thenAccept(factorial -> log.info(
                    "Факторил числа {}: {}. Ещё осталось {}",
                    numbers.get(finalI),
                    factorial,
                    noCalculatedFactorialsCount.decrementAndGet()
            ));
        }

        CompletableFuture.allOf(factorialsFutures.toArray(new CompletableFuture[0]))
                .join();
    }
}
