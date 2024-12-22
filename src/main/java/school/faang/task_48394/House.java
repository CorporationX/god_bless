package school.faang.task_48394;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
public class House {
    private final List<Room> roomList;
    private final List<Food> totalListFood = new ArrayList<>();
    private final int quantityRooms;

    public House(int quantityRooms) {
        this.quantityRooms = quantityRooms;
        roomList = new ArrayList<>(quantityRooms);
    }

    public boolean collectFood(int roomLimit) {
        Collections.shuffle(roomList);
        List<Room> roomsCollectingFood;
        synchronized (roomList) {
            roomsCollectingFood = roomList.stream()
                    .filter(room -> !room.getFoodList().isEmpty()
                            && room.getIsBeingVisited()
                            .compareAndSet(false, true))
                    .limit(roomLimit)
                    .toList();
        }

        if (roomsCollectingFood.isEmpty()) {
            return false;
        }

        synchronized (totalListFood) {
            roomsCollectingFood.forEach(room -> {
                totalListFood.addAll(room.getFoodList());
                room.getFoodList().clear();
                room.getIsBeingVisited().set(false);
            });
        }
        return true;
    }

    public void initializeRooms(List<Food> foodList) {
        for (int i = 0; i < quantityRooms; i++) {
            var room = new Room();
            room.getFoodList().addAll(foodList);
            roomList.add(room);
        }
    }
}
