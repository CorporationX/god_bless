package nice.mice;

import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class House {
    private List<Room> roomList;
    private List<Food> collectedFood;

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = roomList.get(random.nextInt(roomList.size()));
        Room room2 = roomList.get(random.nextInt(roomList.size()));
        if ((room1.hasFood() && room2.hasFood())) {
            collectedFood.addAll(room1.getFoodList());
            room1.removeAllFood();
            collectedFood.addAll(room2.getFoodList());
            room2.removeAllFood();
        }
    }

    public boolean allFoodCollected() {
        for (Room room : roomList) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
