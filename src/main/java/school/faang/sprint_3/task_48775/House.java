package school.faang.sprint_3.task_48775;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    @Getter
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        synchronized (this) {
            List<Room> nonEmptyRooms = new ArrayList<>(rooms.stream()
                    .filter(Room::hasFood)
                    .toList());

            if (nonEmptyRooms.isEmpty()) {
                System.out.println("Все комнаты пусты. Еда собрана.");
                return;
            }

            int roomsToSelect = Math.min(2, nonEmptyRooms.size());
            List<Room> selectedRooms = nonEmptyRooms.stream()
                    .limit(roomsToSelect)
                    .toList();

            List<Food> collectedFromRooms = selectedRooms.stream()
                    .flatMap(room -> room.clearAndGetFood().stream())
                    .toList();

            collectedFood.addAll(collectedFromRooms);
            System.out.println("Собрано еды: " + collectedFromRooms);
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }
}
