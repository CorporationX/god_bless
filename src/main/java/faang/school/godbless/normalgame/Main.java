package faang.school.godbless.normalgame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Pig1Thread());
        executorService.execute(new Pig2Thread());
        executorService.execute(new Pig3Thread());
        executorService.shutdown();
        awaitTermination(executorService);
        System.out.println("Game over!");
    }

    private static void awaitTermination(ExecutorService executorService) {
        try {
            executorService.awaitTermination(5L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
