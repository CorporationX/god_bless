package school.faang.supercow;

import java.util.Random;

public record Player(String name) {
    static Random random = new Random();
    public void startBattle(Boss boss) {
        try {
            System.out.println();
            boss.joinBattle(this);

            int battleDuration = random.nextInt(3000) + 1000;
            Thread.sleep(battleDuration);
            System.out.println(name + " has been fighting for " + battleDuration + " ms");
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            System.out.println(name + "'s battle was interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}
