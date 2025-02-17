package school.faang.theywereverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @Override
    public void run() {
        try {
            log.info("{} execute task: {}", Thread.currentThread().getName(), this.getTitle());
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
