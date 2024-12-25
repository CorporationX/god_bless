package school.faang.miceareverynicebjs48761;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int DELAY = 0;
    private static final int PERIOD = 30;
    private static final int PULL_SIZE = 5;
    private static final int FOOD_NAME_OFFSET_1 = 1;
    private static final int FOOD_NAME_OFFSET_2 = 6;
    private static final int SHUTDOWN_DELAY_SECONDS = 120;

    public static void main(String[] args) {
        House house = new House();

        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.addFood(new Food("Food " + (i + FOOD_NAME_OFFSET_1)));
            room.addFood(new Food("Food: " + (i + FOOD_NAME_OFFSET_2)));
            house.addRoom(room);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(PULL_SIZE);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood,
                    DELAY, PERIOD, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();
            house.printCollectedFood();
            System.out.println("Food in house is collected");
        }, SHUTDOWN_DELAY_SECONDS, TimeUnit.SECONDS);
    }
}
