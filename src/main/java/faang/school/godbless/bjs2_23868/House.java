package faang.school.godbless.bjs2_23868;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
@Setter
public class House {
    private static final int POOL_SIZE = 5;
    private static final int INTERVAL = 5;

    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFood = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        House house = initHouse();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.schedule(house::collectFood, INTERVAL * i, SECONDS);
        }

        executor.shutdown();

        executor.awaitTermination(1, MINUTES);
        log.info("Number of foods after cleaning {}", house.foodAmount());
    }

    private synchronized void collectFood() {
        log.info("Start cleaning rooms");

        List<Room> roomsToBeCleaned = rooms.stream()
                .filter(Room::isNotClean)
                .limit(2)
                .toList();

        roomsToBeCleaned.forEach(room -> {
            var foodFromRoom = room.getFoods();
            collectedFood.addAll(foodFromRoom);
            foodFromRoom.clear();
        });

        log.info("Collected food size after cleaning: {}", collectedFood.size());
    }

    private static House initHouse() {
        List<Room> rooms = initRooms();
        House house = new House(rooms);

        log.info("Number of foods before cleaningNumber of foods before cleaning {}", house.foodAmount());
        return house;
    }

    private long foodAmount() {
        return rooms.stream()
                .mapToLong(r -> r.getFoods().size())
                .sum();
    }

    private static List<Room> initRooms() {
        return List.of(
                new Room(List.of(
                        new Food("pizza"),
                        new Food("ice cream"))),
                new Room(List.of(
                        new Food("apple"),
                        new Food("bananas"))),
                new Room(List.of(
                        new Food("burger"),
                        new Food("potato"))),
                new Room(List.of(
                        new Food("coca-cola"),
                        new Food("pepsi"))),
                new Room(List.of(
                        new Food("draniki"),
                        new Food("machanka"))),
                new Room(List.of(
                        new Food("cake"),
                        new Food("pie")))
        );
    }
}
