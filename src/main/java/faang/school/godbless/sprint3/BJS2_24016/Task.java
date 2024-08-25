package faang.school.godbless.sprint3.BJS2_24016;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("Task %s started %n", task);

        try {
            Thread.sleep(new Random().nextInt(1, 5) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Interrupted exception: {}", e.getMessage());
        }

        if (!Thread.currentThread().isInterrupted()) {
            System.out.printf("Task %s is done!", task);
        }
    }
}
