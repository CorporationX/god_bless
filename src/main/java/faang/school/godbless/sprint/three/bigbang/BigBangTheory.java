package faang.school.godbless.sprint.three.bigbang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BigBangTheory {
    public static void main(String... args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Constants.ACTIVE_THREADS);

        executor.submit(new Task("Sheldon", "Prepare theory"));
        executor.submit(new Task("Leonard", "Modeling experiment"));
        Future<?> futureTask3 = executor.submit(new Task("Hovard", "Develop instruments"));
        executor.submit(new Task("Radzhesh", "Data analyzing"));

        Thread.sleep(Constants.TASK_TIMEOUT);
        futureTask3.cancel(true);

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(Constants.TASK_TIMEOUT);
        }
        System.out.println("All tasks finished");
    }
}
