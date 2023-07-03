package faang.school.godbless.multithreading.supercow;

import java.util.Random;
import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            Thread.sleep(new Random().nextInt(2000, 5000));
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        boss.leaveBattle(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
