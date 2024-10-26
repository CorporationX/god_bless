package school.faang.godbless.bjs2_36089;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        int firstRoomIndex = random.nextInt(rooms.size());
        int secondRoomIndex = random.nextInt(rooms.size());
        Room firstRoom = rooms.get(firstRoomIndex);
        Room secondRoom = rooms.get(secondRoomIndex);
        collectedFood.addAll(firstRoom.getFoodList());
        collectedFood.addAll(secondRoom.getFoodList());
        firstRoom.clearFood();
        secondRoom.clearFood();
    }

    public boolean allFoodCollected() {
        return rooms.stream().filter(room -> !room.getFoodList().isEmpty()).findAny().isEmpty();
    }
}
