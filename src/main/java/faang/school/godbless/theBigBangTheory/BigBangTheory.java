package faang.school.godbless.theBigBangTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        tasks.add(new Task("1", "read"));
        tasks.add(new Task("2", "write"));
        tasks.add(new Task("3", "go"));
        tasks.add(new Task("4", "fly"));

        for (Task task : tasks) {
            executorService.submit(task);
            threads.add(new Thread(task));
        }

        try {
            if (!executorService.awaitTermination(4, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }


        System.out.println("All tasks finished!");
    }
}
