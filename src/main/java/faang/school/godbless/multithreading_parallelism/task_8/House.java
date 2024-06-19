package faang.school.godbless.multithreading_parallelism.task_8;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private final List<Room> rooms;
    private final List<Food> foundFood = new ArrayList<>();

    private final static int THREAD_COUNT = 5;
    private final static int THREAD_TIME_INTERVAL = 30;
    private final static int FOOD_COUNT = 3;
    private final static int ROOM_COUNT = 10;
    private final static int AWAIT_TERMINATION_TIME = 150;

    public static void main(String[] args) {
        House house = new House(getRooms());
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int startIndex = i * 2;
            executor.schedule(() -> house.collectFood(startIndex), THREAD_TIME_INTERVAL * i, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS);
            System.out.println("Food collected! Food count: " + house.foundFood.size());
        } catch (InterruptedException e) {
            throw new RuntimeException("Await termination failed with this exception: " + e);
        }
    }

    private void collectFood(int index) {
        List<Room> twoRoms = rooms.subList(index, index + 2);
        twoRoms.forEach(room -> {
            foundFood.addAll(room.getFoods());
            room.setFoods(null);
        });
        System.out.println("Collected " + (index + 2) + " foods");
    }

    private static List<Room> getRooms() {
        List<Food> foods = getFoods();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < ROOM_COUNT; i++) {
            for (int j = 0; j < FOOD_COUNT; j++) {
                List<Food> randomFoods = new ArrayList<>();
                randomFoods.add(foods.get(new Random().nextInt(foods.size())));
                rooms.add(new Room(randomFoods));
            }
        }
        return rooms;
    }

    private static List<Food> getFoods() {
        return List.of(
                new Food("Sushi"),
                new Food("Lasagna"),
                new Food("Tacos"),
                new Food("Chocolate cake"),
                new Food("Caesar salad"),
                new Food("Pho"),
                new Food("Falafel wrap"),
                new Food("Steak with mashed potatoes"),
                new Food("Pad Thai"),
                new Food("Cheeseburger"));
    }
}
