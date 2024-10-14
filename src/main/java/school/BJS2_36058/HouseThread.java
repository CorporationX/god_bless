package school.BJS2_36058;

import java.util.concurrent.CountDownLatch;

public class HouseThread implements Runnable {

    private final CountDownLatch latch;
    private final House house;

    public HouseThread(House house, CountDownLatch latch) {
        this.latch = latch;
        this.house = house;
    }

    public void run() {
        try {
            house.collectFood();
        } finally {
            if (house.isAll()) {
                latch.countDown();
            }
        }
    }
}
