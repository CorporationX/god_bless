package org.example.model.tomAndJerry;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class House {
    private static final int POOL_SIZE = 5;
    private static final int PERIOD_SECONDS = 30;
    private static final int INITIAL_DELAY = 0;
    private List<Room> rooms;

    public void collectFood() {
        Random random = new Random();
        int sizeOfRooms = rooms.size();
        int firstRoomIndex = random.nextInt(sizeOfRooms);
        int secondRoomIndex = (random.nextInt(sizeOfRooms) + 1) % sizeOfRooms;
        Room firstRoom = rooms.get(firstRoomIndex);
        Room secondRoom = rooms.get(secondRoomIndex);

        if (!firstRoom.getFoods().isEmpty()) {
            rooms.remove(firstRoomIndex);
        }
        if (!secondRoom.getFoods().isEmpty() && !secondRoom.equals(firstRoom)) {
            rooms.remove(secondRoomIndex);
        }
    }

    public boolean isAllFooCollected() {
        return rooms.stream()
                .anyMatch(Room::hasFoods);
    }

    public static void main(String[] args) {
        House house = new House(Arrays.asList(
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk"))),
                new Room(List.of(new Food("Cheese"), new Food("Milk"), new Food("Cheese"), new Food("Milk")))
        ));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, INITIAL_DELAY, PERIOD_SECONDS, TimeUnit.SECONDS);

        if (house.isAllFooCollected()) {
            executor.shutdownNow();
            System.out.println("All food collected!!!");
        } else {
            System.out.println("error");
        }
    }
}
