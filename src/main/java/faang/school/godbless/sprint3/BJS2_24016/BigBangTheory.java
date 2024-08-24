package faang.school.godbless.sprint3.BJS2_24016;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Robert", "Fix computer"),
                new Task("Max", "Deliver goods"),
                new Task("Albert", "Paint wall"),
                new Task("Donald", "Count money")
        ));

        tasks.forEach(executorService::submit);
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("All tasks are done!");
            } else {
                System.out.println("Timeout: ExecutorService did not shut down in time.");
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception {}", e.getMessage());
        }
    }
}
