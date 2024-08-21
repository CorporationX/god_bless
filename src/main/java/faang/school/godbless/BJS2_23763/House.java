package faang.school.godbless.BJS2_23763;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private static final int POOL_SIZE = 5;
    private static final long PERIOD = 5;
    private static final long INIT_DELAY = 0;

    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
    }

    public static void main(String[] args) {
        House house = new House();
        Room roomOne = new Room();
        roomOne.addFoods(Arrays.asList(new Food("Bread"), new Food("Egg"), new Food("Milk")));
        Room roomTwo = new Room();
        roomTwo.addFoods(Arrays.asList(new Food("Chicken breast"), new Food("Cheese")));
        Room roomThree = new Room();
        roomThree.addFoods(Arrays.asList(new Food("Cucumber"), new Food("Potato")));
        Room roomFour = new Room();
        roomFour.addFoods(Arrays.asList(new Food("Rise"), new Food("Apple"), new Food("Banana")));
        Room roomFive = new Room();
        roomFive.addFoods(Arrays.asList(new Food("Carrot"), new Food("Yogurt"), new Food("Butter")));
        house.rooms.addAll(Arrays.asList(roomOne, roomTwo, roomThree, roomFour, roomFive));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            if (!house.isAllRoomsEmpty()) {
                house.collectFood();
            } else {
                executor.shutdown();
            }
        }, INIT_DELAY, PERIOD, TimeUnit.SECONDS);
    }

    private boolean isAllRoomsEmpty() {
        return rooms.stream()
                .allMatch(Room::isEmpty);
    }
}
