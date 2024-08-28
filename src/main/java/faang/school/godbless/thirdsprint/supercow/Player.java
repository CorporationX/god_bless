package faang.school.godbless.thirdsprint.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private static final int BATTLE_TIME_IN_MS = 15000;

    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep((long) (Math.random() * BATTLE_TIME_IN_MS));
        } catch (InterruptedException e) {
            log.error("Interrupted exception: {}", e.getMessage());
            return;
        }
        boss.leaveBattle(this);
    }
}
