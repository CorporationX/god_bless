package faang.school.godbless.BJS2_1219;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public class House {
    private List<Food> collectedFood = new ArrayList<>();
    private List<Room> rooms;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < house.rooms.size() / 2; i++) {
            executor.schedule(house::collectFood, i * 30L, TimeUnit.SECONDS);
        }
        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Collected food: " + house.getCollectedFood());
        System.out.println("Food collected!");
    }

    public void collectFood() {
        int count = 0;
        for (Room room : rooms) {
            if (count >= 2) {
                break;
            }
            if (room.getFoods() == null || room.getFoods().isEmpty()) {
                continue;
            }
            collectedFood.addAll(room.getFoods());
            room.getFoods().clear();
            count++;
        }
        System.out.println("In thread " + Thread.currentThread() + " collected food: " + collectedFood);
    }

    public void initialize() {
        List<Food> foods1 = new ArrayList<>(List.of(new Food("Apple"), new Food("Banana")));
        List<Food> foods2 = new ArrayList<>(List.of(new Food("Bread"), new Food("Donut")));
        List<Food> foods3 = new ArrayList<>(List.of(new Food("Olivie"), new Food("Hamburger")));
        List<Food> foods4 = new ArrayList<>(List.of(new Food("Chicken"), new Food("French fries")));
        List<Food> foods5 = new ArrayList<>(List.of(new Food("Sausage"), new Food("Wings")));
        List<Food> foods6 = new ArrayList<>(List.of(new Food("Coke"), new Food("Pizza")));

        this.rooms = new ArrayList<>(List.of(new Room(foods1), new Room(foods2), new Room(foods3), new Room(foods4), new Room(foods5), new Room(foods6)));
    }
}