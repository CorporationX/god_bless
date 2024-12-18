package school.faang.task_48303;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

@Slf4j
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    @Setter
    private CountDownLatch cdl;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {
        rooms.addAll(
                Stream.of(200, 201, 202, 203, 204, 205, 206, 207)
                        .map(Room::new)
                        .toList()
        );
    }

    public void collectFood() {
        rooms.stream()
                .filter(room -> room.tryLock() && !room.isClear())
                .limit(2)
                .forEach(room -> {
                    try {
                        getFoodFromRoom(room);
                    } finally {
                        room.unlock();
                    }
                });
    }

    private void getFoodFromRoom(Room room) {
        synchronized (collectedFood) {
            collectedFood.addAll(room.collectFood());
        }
        log.info("{} собрал еду из {} комнаты", Thread.currentThread().getName(), room.getNumber());
        if (cdl != null) {
            cdl.countDown();
        } else {
            log.warn("CountDownLatch не инициализирован!");
        }
    }

    public int sizeRooms() {
        return rooms.size();
    }

    public List<Food> getCollectedFood() {
        return new ArrayList<>(collectedFood);
    }
}