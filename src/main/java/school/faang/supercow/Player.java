package school.faang.supercow;

import lombok.Data;

@Data
public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    @Override
    public void run() {
        try {
            boss.joinBattle(this);
            Thread.sleep((long) (Math.random() * 1000));
            boss.leaveBattle(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}