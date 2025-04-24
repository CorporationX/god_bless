package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} сражается с боссом...", name);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.info("{} был прерван во время сражения.", name);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}
