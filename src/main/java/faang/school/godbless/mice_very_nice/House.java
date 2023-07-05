package faang.school.godbless.mice_very_nice;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Food> collectedFoods = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public void collectFood() {
        int roomCleaned = 0;

        for (Room room : rooms) {
            if (roomCleaned == 2) {
                break;
            }

            List<Food> foodsInRoom = room.getFoodsInRoom();
            if (!foodsInRoom.isEmpty()) {
                collectedFoods.addAll(foodsInRoom);
                room.removeFood();
                roomCleaned++;
            }
        }
    }

    public List<Food> getCollectedFoods() {
        return collectedFoods;
    }

    public void initialize() {
        int numRooms = 3;
        int maxFoodPerRoom = 5;

        for (int i = 0; i < numRooms; i++) {
            Room room = new Room();
            room.populateRandomFood(maxFoodPerRoom);
            rooms.add(room);
        }
    }
}
