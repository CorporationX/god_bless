package faang.school.godbless.Supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private static final long FIGHT_TIME = 5000L;
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(FIGHT_TIME);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
