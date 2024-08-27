package faang.school.godbless.bjs224430;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("Player " + this.name + " joined the battle");
        try {
            Thread.sleep((new Random().nextInt(5) + 3) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Player " + this.name + " left the battle");
        boss.endBattle(this);
    }
}
