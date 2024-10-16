package school.faang.mice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Getter
public class House {

    private List<Room> rooms;

    public House(List<Room> rooms) {
        Objects.requireNonNull(rooms, "Rooms cannot be null");
        this.rooms = rooms;
    }

    public List<Food> collectFood() {
        List<Room> dirtyRooms = rooms.stream().filter(Room::hasFood).toList();
        if (dirtyRooms.isEmpty()) {
            return Collections.emptyList();
        }
        if (dirtyRooms.size() == 1) {
            return dirtyRooms.get(0).removeAllFood();
        }

        Random random = new Random();
        int roomIndex1 = random.nextInt(dirtyRooms.size());
        int roomIndex2 = random.nextInt(dirtyRooms.size());
        while (roomIndex1 == roomIndex2) {
            roomIndex2 = random.nextInt(dirtyRooms.size());
        }
        List<Food> collectedFoods = new ArrayList<>();
        collectedFoods.addAll(dirtyRooms.get(roomIndex1).removeAllFood());
        collectedFoods.addAll(dirtyRooms.get(roomIndex2).removeAllFood());

        return collectedFoods;
    }

    public void setRooms(List<Room> rooms) {
        Objects.requireNonNull(rooms, "Rooms cannot be null");
        this.rooms = rooms;
    }
}
