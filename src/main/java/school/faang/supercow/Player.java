package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public record Player(String name) {

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        log.info("Эпическое сражение игрока {}!", name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток {} прерван", Thread.currentThread().getName(), e.getCause());
        }
        boss.leaveBattle(this);
    }
}
