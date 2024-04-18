package faang.school.godbless.multithreading.task_8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;

    public void collectFood(int roomIndex) {
        if (roomIndex >= rooms.size()) {
            return;
        }
        Room room = rooms.get(roomIndex);
        List<Food> foodInRoom = room.getFoods();
        foodInRoom.forEach(
                food -> {
                    collectedFood.add(food);
                    System.out.println(food.getName() + " был добавлен в общее хранилище из " + room.getName());
                });
        foodInRoom.clear();
    }
}