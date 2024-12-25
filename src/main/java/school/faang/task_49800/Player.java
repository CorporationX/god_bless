package school.faang.task_49800;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private static final int BATTLE_LIVE = 2000;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(BATTLE_LIVE);
        } catch (InterruptedException e) {
            System.out.println("!!!Exception!!! " + e);
        }
        boss.finishBattle(this);
    }
}
