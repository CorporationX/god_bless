package school.faang.Weasley;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final List<String> CHORES = List.of("wash the dishes", "sweep the floor", "cook dinner", "clean the room");
    private static final int SHUTDOWN_TIMEOUT_MINUTES = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CHORES.stream().map(Chore::new).forEach(executorService::execute);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(SHUTDOWN_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                System.out.printf("Some tasks were not completed on time, forced completion...%n");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}
