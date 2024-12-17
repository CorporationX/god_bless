package school.faang.task_48356;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class WeasleyFamily {
    public static void main(String[] args) {
        final String[] chores = new String[]{"wash dishes", "sweep floors", "make dinner", "wipe off the dust"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        Stream.of(chores).forEach(chore -> executorService.submit(new Chore(chore)));

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }

        System.out.println("All tasks finished");
    }
}