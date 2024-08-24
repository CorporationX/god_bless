package faang.school.godbless.MiceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }

    public void collectFood() {
        synchronized (this) {
            if (rooms.size() < 2) {
                System.out.println("Not enough rooms to collect food.");
                return;
            }

            Room room1 = rooms.stream().filter(room -> !room.getFoods().isEmpty()).findFirst().orElse(null);
            Room room2 = rooms.stream().filter(room -> !room.getFoods().isEmpty() && room != room1).findFirst().orElse(null);

            if (room1 != null) {
                System.out.println("Collect food from room: " + room1.getName());
                collectedFood.addAll(room1.getFoods());
                room1.clearFoods();
            }

            if (room2 != null) {
                System.out.println("Collect food from room: " + room2.getName());
                collectedFood.addAll(room2.getFoods());
                room2.clearFoods();
            }
        }
    }
}