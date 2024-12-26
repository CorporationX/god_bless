package school.faang.task48606;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
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

        log.info("Поток {} приступил к выполнению задачи", threadName);

        if (rooms.size() < 2) {
            log.info("Недостаточно комнат для выполнения задачи.");
            return;
        }

        Collections.shuffle(rooms);
        Room room1 = rooms.get(0);
        Room room2 = rooms.get(1);

        if (room1.hasFood() && room2.hasFood()) {
            collectedFood.addAll(room1.takeAllFood());
            collectedFood.addAll(room2.takeAllFood());
        } else {
            log.info("В комнатах {} и/или {} уже была собрана еда", room1.getName(), room2.getName());
        }
        log.info("Поток {} закончил задачу", threadName);
    }

    public boolean allFoodCollected() {
        return rooms.stream().noneMatch(Room::hasFood);
    }
}