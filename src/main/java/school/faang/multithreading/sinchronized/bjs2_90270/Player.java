package school.faang.multithreading.sinchronized.bjs2_90270;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public record Player(String name) {
    private static final int TIME_DELAY = 5; // секунд

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("Игрок '{}' в бою с '{}", name, boss.getBossName());
            TimeUnit.SECONDS.sleep(TIME_DELAY);
        } catch (InterruptedException e) {
            log.error("'{}' был прерван во время ожидания", name());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
