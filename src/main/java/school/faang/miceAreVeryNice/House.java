package school.faang.miceAreVeryNice;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final int THREAD_COUNTS = 5;
    private List<Room> allRooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();
    private Random rn = new Random();

    public void collectFood() {
        Room room1 = allRooms.get(rn.nextInt(allRooms.size()));
        Room room2 = allRooms.get(rn.nextInt(allRooms.size()));
        if (!room1.getAllFood().isEmpty()) {
            collectedFood.addAll(room1.getAllFood());
            room1.setAllFood(new ArrayList<>());
        }

        if (!room2.getAllFood().isEmpty()) {
            collectedFood.addAll(room2.getAllFood());
            room2.setAllFood(new ArrayList<>());
        }
    }

    public void init() {
        Food food1 = new Food("Banana");
        Food food2 = new Food("Apple");
        Food food6 = new Food("Strawberry");
        Food food7 = new Food("Blueberry");
        Food food11 = new Food("Plum");
        Food food12 = new Food("Cherry");

        Room room1 = new Room(List.of(food1, food2));
        Room room2 = new Room(List.of(food6, food7));
        Room room3 = new Room(List.of(food11, food12));

        allRooms.addAll(List.of(room1, room2, room3));
    }

    public static void main(String[] args) {
        House house = new House();
        house.init();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_COUNTS);
        executorService.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);

        try {
            Thread.sleep(31000);
            executorService.shutdown();
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All collected foods are: " + house.getCollectedFood());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
