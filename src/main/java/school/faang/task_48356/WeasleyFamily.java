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

        if (!executorService.isTerminated()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("tasks are not finished yet..");
            }
        } else {
            executorService.shutdownNow();
        }

        System.out.println("All tasks finished");
    }
}