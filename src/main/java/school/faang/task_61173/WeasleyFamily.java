package school.faang.task_61173;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("washing the dishes", "sweeping the floor", "cooking dinner");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.err.println("The time to complete task has expired!");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            System.err.println("Completion aborted");
            executorService.shutdown();
        }
    }
}
