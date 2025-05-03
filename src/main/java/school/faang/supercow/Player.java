package school.faang.supercow;

import lombok.Data;

@Data
public class Player implements Runnable {
    private static final int MILLIS = 1000;
    private final String name;
    private final Boss boss;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);

            Thread.sleep(MILLIS + (int) (Math.random() * 2000));

            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        doBattle(boss);
    }
}
