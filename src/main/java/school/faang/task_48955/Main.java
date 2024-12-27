package school.faang.task_48955;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_POOL_SIZE = 5;
    private static final int INIT_DELAY = 0;
    private static final int PERIOD = 3;

    public static void main(String[] args) {

        House house = new House();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        es.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.hasCollectedAllFood()) {
                es.shutdown();
            }
        }, INIT_DELAY, PERIOD, TimeUnit.SECONDS);
        try {
            es.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Еда в доме собрана!");
    }
}
