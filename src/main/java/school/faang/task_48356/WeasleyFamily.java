package school.faang.task_48356;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class WeasleyFamily {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Stream.of(Chores.values()).forEach(chores -> executorService.submit(new Chore(chores)));

        executorService.shutdown();

        if (!executorService.isTerminated()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            executorService.shutdownNow();
        }

        System.out.println("All tasks finished");
    }
}