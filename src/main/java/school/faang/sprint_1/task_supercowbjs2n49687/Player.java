package school.faang.sprint_1.task_supercowbjs2n49687;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        try {
            Thread.sleep((long) (Math.random() * 600));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s wants to join battle \n", this.name);
        boss.joinBattle(this);
    }

    public void leaveBattle(Boss boss) {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s wants to quit battle \n", this.name);
        boss.leaveBattle(this);
    }
}
