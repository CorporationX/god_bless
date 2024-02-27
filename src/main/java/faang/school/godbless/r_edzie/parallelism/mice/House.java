package faang.school.godbless.r_edzie.parallelism.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final int THREAD_AMOUNT = 5;
    private static final int DELAY = 5;
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood() {
        for (Room room : rooms) {
            collectedFood.addAll(room.getFoods());
            room.getFoods().clear();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        House house = House.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        System.out.println(house.getRooms());

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            executor.schedule(house::collectFood, DELAY, TimeUnit.SECONDS);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        System.out.println(house.getCollectedFood());
    }

    private static House initialize() {
        Room room1 = new Room();
        Room room2 = new Room();
        Food food1 = new Food("f1");
        Food food2 = new Food("f2");
        Food food3 = new Food("f3");

        room1.addFood(food1);
        room1.addFood(food3);

        room2.addFood(food2);

        House house = new House();

        house.rooms.add(room1);
        house.rooms.add(room2);

        return house;
    }
}
