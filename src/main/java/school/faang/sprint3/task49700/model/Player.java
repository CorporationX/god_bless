package school.faang.sprint3.task49700.model;

import lombok.Data;

@Data
public class Player {
    private static final int ROUND_TIME_SEC = 5;
    private final String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(ROUND_TIME_SEC * 1000);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
