package faang.school.godbless.mice;

import lombok.Data;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) {
        House house = new House(
                List.of(
                        new Room(0, List.of(new Food("Cheese"), new Food("Sausage"), new Food("Butter"))),
                        new Room(1, List.of(new Food("Bread"), new Food("Baton"), new Food("Milk"))),
                        new Room(2, List.of(new Food("Cheese"), new Food("Chocolate"), new Food("Sausage"))),
                        new Room(3, List.of(new Food("Coffee"), new Food("Baton"), new Food("Pasta"))),
                        new Room(4, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta"))),
                        new Room(5, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta"))),
                        new Room(6, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta"))),
                        new Room(7, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta"))),
                        new Room(8, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta"))),
                        new Room(9, List.of(new Food("Tea"), new Food("Bread"), new Food("Pasta")))
                )
        );
        FoodManager foodManager = new FoodManager(house);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i <= 5; i++) {
            int roomId = i * 2;
            int delay = i * 30;

            executor.schedule(() -> foodManager.collectFood(roomId), delay, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(300, TimeUnit.SECONDS)) {
                System.out.println("All food collected");
            } else {
                System.out.println("Time has expired");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
