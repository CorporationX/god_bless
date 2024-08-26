package mice.are.very.nice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 5;
    private static final int DELAY_INTERVAL = 30;
    private final static int MAX_ROOMS_PER_TIME = 2;


    public static void main(String[] args) throws InterruptedException {
        House house = getHouse();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        int delay = 0;

        for (int i = 0; i < house.getRooms().size(); i += MAX_ROOMS_PER_TIME) {
            List<Room> rooms = house.getRooms().stream()
                    .skip(i)
                    .limit(MAX_ROOMS_PER_TIME)
                    .toList();

            executorService.schedule(() -> house.collectFood(rooms), delay, TimeUnit.SECONDS);
            delay = DELAY_INTERVAL;
        }

        executorService.shutdown();
        if (executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            System.out.println("Еда в доме собрана!");
            System.out.println(house.getCollectedFood());
        }
    }

    private static House getHouse() {
        List<Food> kitchenFoods = new ArrayList<>(
            List.of(
                new Food("Сыр"),
                new Food("Колбаса"),
                new Food("Огурец")
            )
        );
        List<Food> livingRoomFoods = new ArrayList<>(
            List.of(
                new Food("Помидор"),
                new Food("Торт"),
                new Food("Яблоко")
            )
        );
        List<Food> bedroomFoods = new ArrayList<>(
            List.of(
                new Food("Морковь"),
                new Food("Печенье"),
                new Food("Яйца")
            )
        );

        House house = new House(Arrays.asList(
            new Room("Гостиная", livingRoomFoods),
            new Room("Спальня", bedroomFoods),
            new Room("Кухня", kitchenFoods)
        ));

        return house;
    }
}
