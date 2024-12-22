package school.faang.task_bjs249691;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    public void fightBoss(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Прерывание сражения с боссом");
        }
        boss.leaveBattle(this);
    }


}
