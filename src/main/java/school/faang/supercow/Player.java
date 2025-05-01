package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private static final int SLEEP_TIME = 2000;
    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.printf("\n%s начинает сражение с боссом...", name);
            Thread.sleep(SLEEP_TIME);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
