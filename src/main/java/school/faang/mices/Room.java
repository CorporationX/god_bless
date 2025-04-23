package school.faang.mices;

import java.util.List;

public class Room {

    private final int roomNumber;
    private final List<Food> roomFood;

    public Room(int roomNumber, List<Food> roomFood) {
        this.roomNumber = roomNumber;
        this.roomFood = roomFood;
    }

    public Food peekFood() {
        synchronized (roomFood) {
            return roomFood.remove(0);
        }
    }

    public boolean isFoodInTheRoom() {
        synchronized (roomFood) {
            return !roomFood.isEmpty();
        }
    }

    @Override
    public String toString() {
        return "%d - %s".formatted(roomNumber, roomFood);
    }
}