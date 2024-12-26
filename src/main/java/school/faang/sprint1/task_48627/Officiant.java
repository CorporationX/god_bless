package school.faang.sprint1.task_48627;

import java.util.concurrent.CountDownLatch;

public class Officiant extends Thread {
    private final House house;

    public Officiant(House house) {
        this.house = house;

    }

    @Override
    public void run() {
        house.collectFood();
    }
}
