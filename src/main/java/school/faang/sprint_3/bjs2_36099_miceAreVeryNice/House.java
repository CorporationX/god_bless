package school.faang.sprint_3.bjs2_36099_miceAreVeryNice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class House {
    private static final int THREAD_POOL_SIZE = 5;
    private final List<Room> rooms;
    private static final Random RANDOM = new Random();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) {
        List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());

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
                System.out.println("Все пошло не по плану! Глушим потоки!");
            }
        } catch (InterruptedException e) {
            log.error("Произошла ошибка при остановке потоков.");
            throw new RuntimeException(e);
        }
    }

    private List<Food> collectFood() {
        Room firstRandomRoom = rooms.get(RANDOM.nextInt(rooms.size()));
        Room secondRandomRoom = rooms.get(RANDOM.nextInt(rooms.size()));
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

