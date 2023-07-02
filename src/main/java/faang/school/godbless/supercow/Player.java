package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        System.out.println("Player " + name + " want to join the fight with boss");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boss.joinBattle(this);

        try {
            Thread.sleep(new Random().nextInt(3000, 8000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boss.finishBattle(this);
    }
}
