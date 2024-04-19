package faang.school.godbless.BJS2_5801;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final int CORE_POOL_SIZE = 5;
    private static final int DELAY = 30;
    private static final int TIMEOUT = 31000;
    public static List<Room> rooms = new ArrayList<>();


    public static void main(String[] args) {
        initialize();
        ScheduledExecutorService poolService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (int i = 0; i < 5; i++) {
            poolService.schedule(() -> collectFood(rooms), DELAY, TimeUnit.SECONDS);
        }
        poolService.shutdown();

        try {
            if (!poolService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                poolService.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolService.shutdownNow();
        }
    }

    private static void initialize() {
        rooms.add(new Room("Kitchen", List.of(
                new Food("Cheese"),
                new Food("Salami"),
                new Food("Apple"),
                new Food("Milk")
        )));
        rooms.add(new Room("Living room", List.of(
                new Food("Sausage"),
                new Food("Bread"),
                new Food("Butter"),
                new Food("Nuts")
        )));
    }

    private static void collectFood(List<Room> rooms) {
        rooms.stream().flatMap(room -> room.getFoods().stream()).
                forEach(food -> System.out.println(food.getFoodDescription() + " was find"));
    }
}
