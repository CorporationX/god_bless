package faang.school.godbless.BJS2_1124;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    List<Room> rooms = new ArrayList<>();
    List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Food> foods1 = List.of(new Food("Cheese"), new Food("Mozzarella"), new Food("Feta"), new Food("Cheddar"));
        List<Food> foods2 = List.of(new Food("Lamb"), new Food("Beef"), new Food("Duck"), new Food("Veal"));
        List<Food> foods3 = List.of(new Food("Lobster"), new Food("Shrimp"), new Food("Salmon"), new Food("Crab"));
        List<Room> rooms = List.of(new Room(foods1), new Room(foods2), new Room(foods3));
        House house = new House(rooms);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int delay = i * 30;
            executor.schedule(() -> house.collectedFood, delay, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println("All food is collected");
    }

    public void collectFood() {
        int counter = 0;
        for (Room room : rooms) {
            collectedFood.addAll(room.food);
            room.food.clear();
            ++counter;
            if(counter == 2) {
                break;
            }
        }
    }

}
