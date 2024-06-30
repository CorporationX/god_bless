package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player implements Runnable {
    private String name;
    private Boss boss;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep((int)(Math.random() * 10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }

    @Override
    public void run() {
        startBattle(boss);
    }
}
