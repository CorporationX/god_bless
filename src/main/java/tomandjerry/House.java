package tomandjerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Data
public class House {
    private static final int NUMBER_OF_ROOMS_TO_CLEAN = 2;

    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();
    private List<Room> emptyRooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood() {
        for (int i = 0; i < NUMBER_OF_ROOMS_TO_CLEAN; i++) {
            Optional<Room> optionalRoom = getRoomWithFood();
            if (optionalRoom.isPresent()) {
                Room room = optionalRoom.get();
                collectedFood.addAll(room.getFoodList());
                room.removeAllFood();
                emptyRooms.add(room);
            }
        }
    }

    public boolean allFoodCollected() {
        return emptyRooms.size() == rooms.size();
    }

    private Optional<Room> getRoomWithFood() {
        if (allFoodCollected()) {
            return Optional.empty();
        }

        Random random = new Random();
        Room room = rooms.get(random.nextInt(rooms.size()));
        while (!room.hasFood()) {
            room = rooms.get(random.nextInt(rooms.size()));
        }
        return Optional.of(room);
    }
}
