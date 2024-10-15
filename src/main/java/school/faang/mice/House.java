package school.faang.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFoods = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        Food cheese = new Food("cheese");
        Food banana = new Food("banana");
        Food orange = new Food("orange");
        Food chocolate = new Food("chocolate");
        Food chips = new Food("chips");
        Food cherry = new Food("cherry");

        Room room1 = new Room(new ArrayList<>(List.of(cheese, orange)));
        Room room2 = new Room(new ArrayList<>(List.of(banana, chocolate)));
        Room room3 = new Room(new ArrayList<>(List.of(chips)));
        Room room4 = new Room(new ArrayList<>(List.of(chips, cherry)));
        Room room5 = new Room(new ArrayList<>(List.of(chips, orange)));
        Room room6 = new Room(new ArrayList<>(List.of(chips, cheese)));
        house.getRooms().addAll(List.of(room1, room2, room3, room4, room5, room6));

        CountDownLatch latch = new CountDownLatch(1);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(() -> {
            house.collectFood();
            if (house.rooms.isEmpty()) {
                latch.countDown();
            }
        }, 0, 30, TimeUnit.SECONDS);

        latch.await();
        System.out.println("Еда в доме собрана!");
        System.out.println(house.collectedFoods);
        scheduler.shutdown();
    }

    public void collectFood() {
        int[] randomIndexes = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(rooms.size()))
                .distinct()
                .limit(2)
                .toArray();
        Room firstRoom = rooms.get(randomIndexes[0]);
        Room secondRoom = rooms.get(randomIndexes[1]);

        collectedFoods.addAll(firstRoom.getFoods());
        rooms.remove(firstRoom);
        System.out.println("Еда из комнаты собрана");

        collectedFoods.addAll(secondRoom.getFoods());
        rooms.remove(secondRoom);
        System.out.println("Еда из комнаты собрана");
    }
}
