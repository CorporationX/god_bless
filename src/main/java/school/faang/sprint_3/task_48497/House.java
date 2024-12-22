package school.faang.sprint_3.task_48497;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class House {
    private final Random random = new Random();
    private final Queue<Room> rooms = new ArrayDeque<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public void addRoom(Room room) {
        List<Room> currentRooms = new ArrayList<>(rooms);
        currentRooms.add(room);
        Collections.shuffle(currentRooms);
        rooms.clear();
        rooms.addAll(currentRooms);
    }

    public boolean collectFood() {
        Room room1 = getRandomRoom();
        Room room2 = getRandomRoom();

        synchronized (collectedFood) {
            if (Objects.nonNull(room1)) {
                collectedFood.addAll(room1.collectFood());
            }
            if (Objects.nonNull(room2)) {
                collectedFood.addAll(room2.collectFood());
            }
        }
        return isCollected();
    }

    private synchronized Room getRandomRoom() {
        return rooms.poll();
    }

    public synchronized boolean isCollected() {
        return rooms.isEmpty();
    }
}
