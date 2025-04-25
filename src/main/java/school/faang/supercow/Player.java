package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {

    private static final int SLEEP_TIME = 2000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом...", name);
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            log.info("{} был прерван во время сражения.", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
