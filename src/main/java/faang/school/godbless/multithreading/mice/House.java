package faang.school.godbless.multithreading.mice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class House {
    private final List<Room> roomWithFood = new LinkedList<>();
    private final List<Food> collectedFood  = new ArrayList<>();

    public void addRoom(Room room) {
        roomWithFood.add(room);
    }

    public void collectFood() {
        Room room = roomWithFood.get(0);
        collectedFood.addAll(room.foods());

        System.out.println("Из комнаты " + room.name() + " собрана еда:");
        showCollectedFoodFromRoom(room);

        roomWithFood.remove(0);
    }

    public void showCollectedFoodFromRoom(Room room) {
        for (Food food : room.foods()) {
            System.out.println("\t" + food);
        }
    }
}
