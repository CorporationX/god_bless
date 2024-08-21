package faang.school.godbless.sprint3.BJS2_23798;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
@Setter
public class House {
    private List<Room> allRooms;
    private List<Food> allFood;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of(
                new Room("Kitchen", new ArrayList<>(List.of(
                        new Food("Apple"),
                        new Food("Lollipop"),
                        new Food("Corn")
                ))),
                new Room("Tom's room", new ArrayList<>(List.of(
                        new Food("Chips"),
                        new Food("Fries"),
                        new Food("Backed mouse")
                ))),
                new Room("Jerry's room", new ArrayList<>(List.of(
                        new Food("Chips"),
                        new Food("Cheese"),
                        new Food("More cheese")
                )))
        )), new ArrayList<>());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.schedule(house::collectFood, 30 * i, TimeUnit.SECONDS);
        }

        house.getAllRooms().forEach(room -> room.getFood().clear());

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(150, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.out.println("ThreadPool interrupted");
            } else {
                System.out.println("All food has been collected");
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private void collectFood() {
        allRooms.stream()
                .flatMap(r -> r.getFood().stream())
                .forEach(f -> allFood.add(f));
    }
}
