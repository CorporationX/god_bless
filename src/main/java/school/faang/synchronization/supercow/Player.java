package school.faang.synchronization.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(3000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
