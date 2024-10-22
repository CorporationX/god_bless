package miceAreVeryNice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFoods = new ArrayList<>();

    public void collectFood() {
        int quantityRooms = 2;
        for (int i = 0; i < quantityRooms; i++) {
            processRandomRoom();
        }
    }

    private void processRandomRoom() {
        if (!rooms.isEmpty()) {
            Room room = rooms.get(new Random().nextInt(rooms.size()));
            collectedFoods.addAll(room.collectFood());
        }
    }

    public void addRoom(Room room) {
        if (!rooms.isEmpty()) {
            rooms.add(room);
        }
    }

}
