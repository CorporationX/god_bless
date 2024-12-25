package school.faang.task_48713;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {
    @Getter
    private final List<Room> rooms;
    private List<Food> collectedFood;

    @Setter
    private CountDownLatch latch;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        createRooms();
    }

    public void createRooms() {
        for (int i = 1; i < 10; i++) {
            rooms.add(new Room("room" + i));
        }
    }

    public void collectFood() {
        List<Room> shuffledRooms = new ArrayList<>(rooms);
        Collections.shuffle(shuffledRooms);

        int collectedRooms = 0;

        for (Room room : shuffledRooms) {
            if (room.getLock().tryLock()) {
                try {
                    if (!room.isClear()) {
                        getFoodFromRoom(room);
                        collectedRooms++;

                        if (collectedRooms == 2) {
                            break;
                        }
                    }
                } finally {
                    room.getLock().unlock();
                }
            }
        }

    }


    private void getFoodFromRoom(Room room) {
        collectedFood.addAll(room.collectFood());

        log.info("{} collected  food from {}", Thread.currentThread().getName(), room.getRoom());
        latch.countDown();
    }
}
