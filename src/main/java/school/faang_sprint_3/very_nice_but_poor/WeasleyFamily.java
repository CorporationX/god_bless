package school.faang_sprint_3.very_nice_but_poor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {

        List<Chore> chores = Arrays.asList(
                new Chore("Wash the dish"),
                new Chore("Wipe the floor"),
                new Chore("Cook the dinner")
        );

        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(executorService::submit);
        executorService.shutdown();

        var timeForTasks = 5;
        try {
            if (!executorService.awaitTermination(timeForTasks, TimeUnit.MINUTES)) {
                System.out.println("Tasks wasn't done in time" + timeForTasks + "minutes, shutdown now");
                executorService.shutdownNow();
            }
        } catch (
                InterruptedException e) {
            System.out.println("Main thread was interrupted, then shutdown now");
            executorService.shutdownNow();
        }
    }
}
