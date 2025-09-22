package school.faang.they.were.very.nice.but.extremely.poor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Chore(String chore) implements Runnable {
    @Override
    public void run() {
        try {
            log.info("выполняет задачу: {}", chore);
            Thread.sleep(1000);
            log.info("{} выполена!", chore);
        } catch (InterruptedException e) {
            log.error("Задача {} была прервана.", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
