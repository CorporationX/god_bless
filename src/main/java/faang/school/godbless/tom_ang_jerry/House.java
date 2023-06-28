package faang.school.godbless.tom_ang_jerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {

    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        int roomsCleaned = 0;

        for (Room room : rooms) {
            if (roomsCleaned == 2) {
                break;
            }

            List<Food> foodInTheRoom = room.getFoodInTheRoom();
            if (foodInTheRoom.isEmpty()) {
                continue;
            } else {
                collectedFood.addAll(foodInTheRoom);
                room.removeFoodFromTheRoom();
                roomsCleaned++;
            }
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
