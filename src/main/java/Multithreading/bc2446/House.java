package Multithreading.bc2446;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {

    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedfoods = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        int countOfRoom = 0;
        for (Room room : rooms) {
            if (countOfRoom == 2) break;
            if (room.getRoomFoods().isEmpty()) continue;
            collectedfoods.addAll(room.getRoomFoods());
            room.removeFoods();
            countOfRoom++;
        }

    }
}
