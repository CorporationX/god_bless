package school.faang.bjs2_73621;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    public static int BATTLE_TIME = 30000;
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            throw new IllegalStateException("The thread was interrupted during battle", e);
        }
        boss.leaveBattle(this);
    }
}
