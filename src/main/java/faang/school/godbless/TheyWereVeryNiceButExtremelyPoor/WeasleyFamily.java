package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {"run", "jump", "swim", "fly"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream.of(chores).forEach((chore) -> executor.execute(new Chore(chore)));
        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            } else {
                System.out.println("All tasks have been completed");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }
}
