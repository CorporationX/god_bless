package school.faang.sprint_3.task_48584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }

    public void collectFood() {
        String threadName = Thread.currentThread().getName();

        System.out.println("Поток " + threadName + " приступил к выполнению задачи");

        Collections.shuffle(rooms);
        Room room1 = rooms.get(0);
        Room room2 = rooms.get(1);

        if (room1.hasFood() && room2.hasFood()) {
            collectedFood.addAll(room1.takeAllFood());
            collectedFood.addAll(room2.takeAllFood());
        } else {
            System.out.println(
                    "В комнатах " + room1.getName()
                            + " и/или " + room2.getName()
                            + " уже была собрана еда"
            );
        }

        System.out.println("Поток " + threadName + " закончил задачу");
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}
