package faang.school.godbless.sprint_3.task_48727;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        House house = House.initHouse();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        executorService.scheduleAtFixedRate(() -> {
            if (house.isNoFoodInAllRooms()) {
                executorService.shutdown();
                System.out.println("Еда в доме собрана!");
                System.out.println(house.getCollectedFood());
                return;
            }
            house.collectFood();
        }, 0, 30, TimeUnit.SECONDS);

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены!");
            }
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }
    }
}
