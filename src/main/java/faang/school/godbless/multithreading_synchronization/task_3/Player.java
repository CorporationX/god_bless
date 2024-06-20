package faang.school.godbless.multithreading_synchronization.task_3;

import java.util.Random;

public record Player(String name) {

    private static final int MIN_BATTLE_TIME = 2000;
    private static final int MAX_BATTLE_TIME = 10000;

    public void startBattle(Boss boos) {
        boos.joinBattle(this);
        try {

            Thread.sleep(new Random().nextInt(MIN_BATTLE_TIME, MAX_BATTLE_TIME));
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread was interrupted while " + this.name + " was fighting " + e);
        }
        boos.leaveBattle(this);
    }
}
