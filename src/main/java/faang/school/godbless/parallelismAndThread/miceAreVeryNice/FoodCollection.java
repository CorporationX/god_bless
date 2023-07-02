package faang.school.godbless.parallelismAndThread.miceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FoodCollection {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int PAUSE_SECONDS = 10;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int index = i * 2;
            int delay = PAUSE_SECONDS * i;
            executorService.schedule(() -> house.collectFood(index), delay, TimeUnit.SECONDS);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Вся еда собрана. Количество: " + house.getCollectedFood().size());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
