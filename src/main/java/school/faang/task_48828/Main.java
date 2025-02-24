package school.faang.task_48828;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Main {
    static final int COUNT_MOUSE = 3;
    static final int DELAY = 0;
    static final int FREQUENCY = 1;

    public static void main(String[] args) {
        House house = new House();

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(COUNT_MOUSE);
        for (int i = 0; i < COUNT_MOUSE; i++) {
            executor.scheduleAtFixedRate(new Mouse(house), DELAY, FREQUENCY, TimeUnit.SECONDS);
        }
        while (true) {
            if (!house.isWork()) {
                executor.shutdown();
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Well done!");
    }
}
