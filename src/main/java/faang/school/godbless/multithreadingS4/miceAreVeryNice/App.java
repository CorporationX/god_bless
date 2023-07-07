package faang.school.godbless.multithreadingS4.miceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int COUNT_ROOMS_FOR_VISIT = 2;
    private static final int STEP_DELAY = 5;

    public static void main(String[] args) {
        House house = new House("House");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        int delay = 0;

        for (int i = 0, j = 1; i < house.getRooms().size(); i += COUNT_ROOMS_FOR_VISIT, j++) {
            int startIndex = i;
            executorService.schedule(
                    () -> house.collectFood(startIndex, COUNT_ROOMS_FOR_VISIT),
                    delay, TimeUnit.SECONDS);
            delay += STEP_DELAY;
            System.out.printf("%S:%d %S%n",
                    "the thread",
                    j,
                    "is scheduled to run."
                    );
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                int countCollectedFood = house.getCollectFood().size();
                System.out.printf("The food collection is finished, count = %d", countCollectedFood);
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
