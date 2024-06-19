package faang.school.godbless.multithreading.bigbang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Task(String name, String task) implements Runnable {

    @Override
    public void run() {
        log.info("{} started working on a task {}", this.name, this.task);
        try {
            Thread.sleep(5000);
            log.info("{} completed a task {}", this.name, this.task);
        } catch (InterruptedException e) {
            log.warn("{} couldn't complete the task {}", this.name, this.task);
        }
    }
}
