package school.faang.sprint3.bjs_48206;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final int roomNumber;
    private final List<Food> foodInRoom;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        foodInRoom = new ArrayList<>();
    }

    public void addFood(String foodName) {
        foodInRoom.add(new Food(foodName));
    }

    public List<Food> getFoodFromRoom() {
        return foodInRoom;
    }

    public boolean isRoomCleaned() {
        return foodInRoom.isEmpty();
    }

    public void cleanRoom() {
        foodInRoom.clear();
    }
}
