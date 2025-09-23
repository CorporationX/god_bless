package school.faang.module3.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Player(String name) {

    private static final int BATTLE_TIME_MS = 3000;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            log.info("Player {} is now having a battle with Boss", this.name());
            Thread.sleep(BATTLE_TIME_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        boss.leaveBattle(this);
    }
}
