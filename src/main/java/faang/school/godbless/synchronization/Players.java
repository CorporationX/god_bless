package faang.school.godbless.synchronization;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Random;

@ToString
@AllArgsConstructor
public class Players {
    private String name;

    public void fightTheBoss(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.println(name + " Battle with boss");
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Error while waiting for battle to finish");
        }
        boss.endBattle(this);
    }
}
