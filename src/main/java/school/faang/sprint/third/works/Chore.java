package school.faang.sprint.third.works;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;

@Slf4j
public class Chore implements Runnable {
    private static final int MAX_TIME_OUT = 10000;
    private final Random random = new Random();
    @NonNull
    private final String chore;

    public Chore(@NonNull String chore) {
        validateChore(chore);
        this.chore = chore;
    }

    @Override
    public void run() {
        log.info("Do {} in thread {} at: {}", chore, Thread.currentThread().getName(), new Date());
        try {
            Thread.sleep(random.nextInt(MAX_TIME_OUT));
        } catch (InterruptedException e) {
            log.error("Thread sleep interrupted: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("Do {} in thread {} is over at: {}", chore, Thread.currentThread().getName(), new Date());
    }

    private void validateChore(@NonNull String chore) {
        if (chore.isBlank()) {
            throw new IllegalArgumentException("Chore name cannot be blank");
        }
    }
}
