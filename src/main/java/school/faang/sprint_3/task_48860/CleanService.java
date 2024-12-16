package school.faang.sprint_3.task_48860;

import java.util.concurrent.*;

public class CleanService {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int DELAY = 0;
    private static final int PERIOD = 3;

    public static void main(String[] args) {
        House house = new House();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(new FoodService(house, executor), DELAY, PERIOD, TimeUnit.SECONDS);
    }
}
