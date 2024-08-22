package faang.school.godbless.sprint.three.cachedthread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String... args) {
        String[] chores = {"Do the dishes", "Do the laundry", "Iron the shirts", "Wash the floors", "Cook dinner"};

        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(chore -> executor.execute(new Chore(chore)));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(4, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Finish");

    }
}
