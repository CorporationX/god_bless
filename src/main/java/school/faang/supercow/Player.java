package school.faang.supercow;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {
    public void doBattle(@NonNull Boss boss) {
        log.info("Player {} trying to join...", this.name());
        boss.joinBattle(this);
        try {
            log.info("Player {} started the battle.", this.name());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted while battle.", Thread.currentThread(), e);
            return;
        }
        boss.leaveBattle(this);
    }
}
