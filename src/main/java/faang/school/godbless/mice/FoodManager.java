package faang.school.godbless.mice;

import java.util.ArrayList;
import java.util.List;

public class FoodManager {
    private final List<Food> allFood = new ArrayList<>();
    private final House house;

    public FoodManager(House house) {
        this.house = house;
    }

    public void collectFood(int roomId) {
        List<Room> batchRooms = house.getRooms().subList(roomId, roomId + 2);

        for (Room room : batchRooms) {
            allFood.addAll(room.getFoodList());
            removeFoodFromRoom(room);
        }

        System.out.println(allFood);
    }

    public void removeFoodFromRoom(Room room) {
        room.setFoodList(null);
    }
}
