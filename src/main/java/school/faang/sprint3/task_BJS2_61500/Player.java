package school.faang.sprint3.task_BJS2_61500;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Player {
    private static final int DURATION_OF_BATTLE = 1000;

    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(DURATION_OF_BATTLE);
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
