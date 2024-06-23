package BJS2_12564;

import java.util.Random;

record Player(String name, Boss boss) implements Runnable {
    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(new Random().nextInt(10000, 15000));
        boss.leaveBattle(this);
    }

    @Override
    public void run() {
        try {
            startBattle(boss);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}