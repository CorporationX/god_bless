package school.faang.bjs2_73869;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Player {
    private static final int BATTLE_DURATION = 3000;

    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("Player {} started fight with boss", this.name);
            Thread.sleep(BATTLE_DURATION);
            log.info("Player {} finished fight with boss", this.name);
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            Thread.currentThread().interrupt();
        }

        boss.leaveBattle(this);
    }
}