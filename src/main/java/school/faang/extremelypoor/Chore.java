package school.faang.extremelypoor;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public record Chore(String title) implements Runnable {
    @Override
    public void run() {
        log.info("{} данную задачу выполняет поток {}", title, Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.warn("Поток {} был прерван во время ожидания", Thread.currentThread().getName(), e);
            Thread.currentThread().interrupt();
        }
    }
}