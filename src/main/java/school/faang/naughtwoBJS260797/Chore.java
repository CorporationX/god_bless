package school.faang.naughtwoBJS260797;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Chore implements Runnable {
    private final String title;
    private Random random = new Random();

    public Chore(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        try {
            log.info("Thread {} is processing task {}", Thread.currentThread().getName(), title);
            Thread.sleep(random.nextInt(1000) + 500);
            log.info("Task {} is completed", title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Thread was interrupted while processing task: " + title, e);
        }
    }
}
