package faang.school.godbless.synchronization.task_3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boss.leaveBattle(this);
    }
}