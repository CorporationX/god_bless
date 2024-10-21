package faang.school.godbless.mt.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(Boss boss, int battleTime) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(battleTime);
        boss.leaveBattle(this);
    }
}
