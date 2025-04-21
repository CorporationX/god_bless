package school.faang.parallelism_3_1.bjs2_72905;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class Chore implements Runnable {
    private final String chore;
    @Override
    public void run() {
        var threadName = Thread.currentThread().getName();
        log.info("Начало выполнения задачи {} потоком {}", this.chore, threadName);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            log.warn("Поток {} был прерван!", threadName);
            Thread.currentThread().interrupt();
        }
        log.info("Задача {}, выполненная потоком {} завершилась", this.chore, threadName);
    }
}
