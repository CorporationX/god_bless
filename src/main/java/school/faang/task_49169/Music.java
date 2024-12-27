package school.faang.task_49169;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            List<Runnable> tasks = List.of(
                    () -> safeExecute(player::play),
                    () -> safeExecute(player::pause),
                    () -> safeExecute(player::skip),
                    () -> safeExecute(player::previous),
                    () -> safeExecute(player::play),
                    () -> safeExecute(player::pause)
            );

            tasks.forEach(executor::execute);

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