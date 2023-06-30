package faang.school.godbless.multithreading.nice_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        List<Chore> chores = List.of(
                new Chore("task1"),
                new Chore("task2"),
                new Chore("task3"),
                new Chore("task4")
        );
        ExecutorService service = Executors.newCachedThreadPool();

        chores.forEach(chore -> service.submit(chore));

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
        service.shutdownNow();
    }
}
