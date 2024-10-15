package school.faang.m1s3.bjs2_36680_bigbang;

import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Random;

@RequiredArgsConstructor
public class Task implements Runnable {
    private final String assignee;
    private final String description;

    @Override
    public void run() {
        System.out.printf("Tread #%d %s: %s started %s%n",
                Thread.currentThread().getId(), LocalTime.now(), assignee, description);
        try {
            Thread.sleep(new Random().nextInt(1, 10) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Task was interrupted");
        }
        System.out.printf("Tread #%d %s: %s successfully finished %s%n",
                Thread.currentThread().getId(), LocalTime.now(), assignee, description);
    }
}
