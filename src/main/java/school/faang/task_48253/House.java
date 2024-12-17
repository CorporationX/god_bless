package school.faang.task_48253;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final Random rand = new Random();
    private final List<Food> collectedFoods = new ArrayList<>();

    public void collectFood() {
        while (true) {
            Room room1 = rooms.stream()
                    .filter(Room::hasFood)
                    .findAny()
                    .orElse(null);

            Room room2 = rooms.stream()
                    .filter(r -> r.hasFood() && r != room1)
                    .findAny()
                    .orElse(null);

            if (room1 == null || room2 == null) {
                return;
            }

            if (room1.getLock().tryLock() && room2.getLock().tryLock()) {
                try {
                    collectFoodFromRoom(room1);
                    collectFoodFromRoom(room2);
                    break;
                } finally {
                    room1.getLock().unlock();
                    room2.getLock().unlock();
                }
            }
        }
    }

    private void collectFoodFromRoom(Room room) {
        collectedFoods.addAll(room.getFoods());
        room.getFoods().clear();
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
