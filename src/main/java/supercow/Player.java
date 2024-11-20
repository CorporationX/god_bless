package supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private static final int FIGHTING_TIME_MS = 2_000;

    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(FIGHTING_TIME_MS);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Что-то пошло не так при вызове метода sleep().");
        }
        boss.leaveBattle(this);
    }
}
