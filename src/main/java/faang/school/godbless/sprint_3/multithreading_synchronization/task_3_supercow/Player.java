package faang.school.godbless.sprint_3.multithreading_synchronization.task_3_supercow;

import java.util.Random;

public class Player {
    public static final Random rand = new Random();
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(rand.nextInt(5) * 1000);
        boss.leaveBattle(this);
    }


}
