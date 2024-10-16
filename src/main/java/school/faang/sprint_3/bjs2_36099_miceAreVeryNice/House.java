package school.faang.sprint_3.bjs2_36099_miceAreVeryNice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class House {
    private static final int THREAD_POOL_SIZE = 5;
    private List<Room> rooms;

    public static void main(String[] args) {
        List<Food> collectedFood = new ArrayList<>();
        House house = new House(HouseInitializer.getFiveRandomRooms());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> {
            collectedFood.addAll(house.collectFood());
            if (house.isAllFoodCollected()) {
                executor.shutdown();
                System.out.println("Вся еда в доме собрана! Вот что мы нашли: ");
                collectedFood.forEach(food -> System.out.println(food.getFoodType()));
            }
        }, 0, 5, TimeUnit.SECONDS);

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                System.out.println("Все пошло не по плану!");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Food> collectFood() {
        Random random = new Random();
        Room firstRandomRoom = rooms.get(random.nextInt(rooms.size()));
        Room secondRandomRoom = rooms.get(random.nextInt(rooms.size()));
        List<Room> roomsToCollect = List.of(firstRandomRoom, secondRandomRoom);
        List<Food> collectedFood = new ArrayList<>();

        roomsToCollect.stream()
                .filter(Room::hasFood)
                .peek(room -> collectedFood.addAll(room.getFoodList()))
                .forEach(Room::removeAllFood);

        return collectedFood;
    }

    private boolean isAllFoodCollected() {
        return rooms.stream()
                .noneMatch(Room::hasFood);
    }
}

