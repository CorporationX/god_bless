package school.faang.task_48922;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    static final int COUNT_OF_ROOMS = 10;
    private final List<Room> rooms;
    private final List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null");
        }
        rooms.add(room);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoodList().isEmpty());
    }

    public void collectFood() {
        Room firstRoom;
        Room secondRoom;

        synchronized (rooms) {
            List<Room> roomsWithFood = rooms.stream()
                    .filter(room -> !room.getFoodList().isEmpty())
                    .toList();

            Random random = new Random();
            firstRoom = roomsWithFood.get(random.nextInt(roomsWithFood.size()));

            do {
                secondRoom = roomsWithFood.get(random.nextInt(roomsWithFood.size()));
            } while (firstRoom == secondRoom);
        }

        synchronized (firstRoom) {
            synchronized (secondRoom) {
                System.out.println(Thread.currentThread().getName() + " collects food from "
                        + firstRoom.getName() + " and " + secondRoom.getName());
                collectedFood.addAll(firstRoom.removeAllFood());
                collectedFood.addAll(secondRoom.removeAllFood());
            }
        }
    }


    public void initialize() {
        for (int i = 1; i <= COUNT_OF_ROOMS; i++) {
            Room room = new Room("Room " + i);
            room.addFood(new Food("FoodItem_" + i + "A"));
            room.addFood(new Food("FoodItem_" + i + "B"));
            addRoom(room);
        }
    }
}
