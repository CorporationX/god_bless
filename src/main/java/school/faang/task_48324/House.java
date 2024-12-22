package school.faang.task_48324;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class House implements Runnable {
    private static final int THREADS_COUNT = 5;
    private static final int ROOMS_TO_COLLECT_COUNT = 2;
    private static final int SLEEP_TIME = 1000;

    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    @Override
    public void run() {
        collectFood();
    }

    public void collectFood() {
        for (var i = 0; i < ROOMS_TO_COLLECT_COUNT; i++) {
            int roomIndex = (int) (Math.random() * rooms.size());
            List<Food> foodList = rooms.get(roomIndex).getFoodList();

            collectedFood.addAll(foodList);
            foodList.clear();
        }
    }


    public boolean isFoodCollected() {
        for (var room : rooms) {
            if (!room.getFoodList().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Room kitchen = new Room("kitchen");
        kitchen.getFoodList().addAll(List.of(new Food("Cheese"),
                                             new Food("Sausage"),
                                             new Food("Bread")));

        Room livingRoom = new Room("livingRoom");
        livingRoom.getFoodList().addAll(List.of(new Food("Soup"),
                                                new Food("Steak"),
                                                new Food("Salad")));

        Room bedroom = new Room("bedroom");
        bedroom.getFoodList().addAll(List.of(new Food("Cake"),
                                             new Food("Cookies"),
                                             new Food("Candies")));

        House house = new House();
        house.getRooms().addAll(List.of(kitchen, livingRoom, bedroom));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREADS_COUNT);

        for (var i = 0; i < THREADS_COUNT; i++) {
            service.scheduleAtFixedRate(house, 0, 30, TimeUnit.SECONDS);
        }

        while (!house.isFoodCollected()) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                log.warn("Main thread was interrupted", e);
            }
        }

        service.shutdown();
        System.out.println("Еда в доме собрана!");

        System.out.println("Rooms: " + house.getRooms());
        System.out.println("Collected food: " + house.getCollectedFood());
    }
}
