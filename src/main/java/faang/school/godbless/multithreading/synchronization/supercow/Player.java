package faang.school.godbless.multithreading.synchronization.supercow;

import lombok.Data;

import java.util.Random;

@Data
public class Player {
    private String name;

    private Random random = new Random();

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            Thread.sleep(random.nextInt(2000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while waiting in battle");
        }

        boss.leaveBattle(this);
    }
}

