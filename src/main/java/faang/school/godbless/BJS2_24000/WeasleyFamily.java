package faang.school.godbless.BJS2_24000;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chore = {"task1", "task2", "task3", "task4", "task5"};
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chore).forEach(choreName -> executor.execute(new Chore(choreName)));
        try {
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
