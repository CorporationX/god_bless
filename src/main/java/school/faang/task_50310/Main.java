package school.faang.task_50310;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static school.faang.task_50310.Factorial.factorials;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<Integer> numbers = List.of(5, 12, 15, 20, 25);
        List<CompletableFuture<BigInteger>> futures = factorials(numbers);

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> futures.forEach(future -> {
                    try {
                        logger.info("Result: {}", future.join());
                    } catch (Exception e) {
                        logger.error("Error during result processing", e);
                    }
                }))
                .join();

        logger.info("All tasks are ended");
    }
}
