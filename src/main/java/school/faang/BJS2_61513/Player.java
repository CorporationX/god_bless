package school.faang.BJS2_61513;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    private static final long SLEEP_TIME_MILLIS = 2000;

    public synchronized void doBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом...", name);
            Thread.sleep(SLEEP_TIME_MILLIS);
        } catch (InterruptedException e) {
            log.info("{} был прерван во время сражения.", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
            log.info("{} покидает бой.", name);
        }
    }
}