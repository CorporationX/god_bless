package school.faang.Weasley;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("wash the dishes", "sweep the floor", "cook dinner", "clean the room");
        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.stream().map(Chore::new).forEach(executorService::execute);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Some tasks were not completed on time, forced completion...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
