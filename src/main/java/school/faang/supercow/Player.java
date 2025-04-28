package school.faang.supercow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {
    private static final int BATTLE_TIME_MC = 5000;
    private final String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIME_MC);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted during battle.", e);
        }
        boss.leaveBattle(this);
    }
}