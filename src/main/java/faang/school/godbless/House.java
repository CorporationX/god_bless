package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        for (Room room : rooms) {
            List<Food> foodInRoom = room.getFood();
            collectedFood.addAll(foodInRoom);
            foodInRoom.clear();
        }
    }

    public boolean isFoodCollected() {
        for (Room room : rooms) {
            if (!room.getFood().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
