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
        rooms.add(room);
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoodList().isEmpty());
    }

    public synchronized void collectFood() {

        List<Room> roomsWithFood = rooms.stream()
                .toList();

        Random random = new Random();
        Room room1 = roomsWithFood.get(random.nextInt(roomsWithFood.size()));
        Room room2;

        do {
            room2 = roomsWithFood.get(random.nextInt(roomsWithFood.size()));
        } while (room1 == room2);

        System.out.println(Thread.currentThread().getName() + " собирает еду из " + room1.getName()
                + " и " + room2.getName());
        collectedFood.addAll(room1.removeAllFood());
        collectedFood.addAll(room2.removeAllFood());
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
