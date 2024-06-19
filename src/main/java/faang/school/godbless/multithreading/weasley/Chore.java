package faang.school.godbless.multithreading.weasley;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        log.info("{} is being done by {}", this.chore, Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            log.info("{} - DONE!", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
