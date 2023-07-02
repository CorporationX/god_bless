package faang.school.godbless.MiceAreVeryNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Room> rooms = setUpRooms();
        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < house.getRooms().size() + 1; i += 2) {
            int start = i;
            int end = start + 2;
            executorService.schedule(() -> collectFood(house, start, end), 30L * start, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        boolean foodCollected = house.getCollectedFood().size() == 7
                && house.getRooms().stream().allMatch(room -> room.getFoodList().size() == 0);
        if (foodCollected) {
            System.out.println("All food collected");
        }
    }

    private static List<Room> setUpRooms() {
        return List.of(
                new Room(1, List.of(new Food("Salad"), new Food("Sandwich"))),
                new Room(2, List.of(new Food("Bread"), new Food("Steak"))),
                new Room(3, List.of(new Food("Tuna Steak"), new Food("Fish"))),
                new Room(4, List.of(new Food("Shrimp")))
        );
    }

    public static void collectFood(House house, int start, int end) {
        for (int i = start; i < end; i++) {
            if (house.getRooms().get(i).getFoodList().size() != 0) {
                house.getCollectedFood().addAll(house.getRooms().get(i).getFoodList());
                house.getRooms().get(i).setFoodList(new ArrayList<>());
            }
        }
    }
}
