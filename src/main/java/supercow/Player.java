package supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Player {
    private final static int MAX_DELAY = 5000;
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.printf("Player %s приступил к сражению с босом\n", this.name);

        try {
            Thread.sleep(new Random().nextInt(MAX_DELAY));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Player %s завершил сражение с босом\n", this.name);
        boss.leaveBattle(this);
    }
}
