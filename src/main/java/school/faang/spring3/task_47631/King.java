package school.faang.spring3.task_47631;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Knight knight1 = new Knight("Alex");
        Knight knight2 = new Knight("Ben");
        knight1.addTrial(new Trial(knight1.getName(), "fight"));
        knight1.addTrial(new Trial(knight1.getName(), "One to one"));
        knight2.addTrial(new Trial(knight2.getName(), "One to one"));
        knight2.addTrial(new Trial(knight2.getName(), "One to many"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        knight1.startTrial(service);
        knight2.startTrial(service);

        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Time is up");
        }
        service.shutdown();
    }
}
