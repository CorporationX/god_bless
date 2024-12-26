package school.faang.task_49169;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            executor.execute(() -> safeExecute(player::play));
            executor.execute(() -> safeExecute(player::pause));
            executor.execute(() -> safeExecute(player::skip));
            executor.execute(() -> safeExecute(player::previous));

            executor.execute(() -> safeExecute(player::play));
            executor.execute(() -> safeExecute(player::pause));
        } catch (Exception e) {
            System.out.println("Error while working with threads: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void safeExecute(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            System.out.println("Error in the stream: " + e.getMessage());
        }
    }
}