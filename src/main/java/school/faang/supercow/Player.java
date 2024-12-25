package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    public static final int BATTLE_DURATION_MS = 3000;

    private final String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(BATTLE_DURATION_MS);
        boss.leaveBattle(this);
    }
}