package school.faang.mice_are_very_nice;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

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

    private void createRooms() {
        for (int i = 1; i < 9; i++) {
            rooms.add(new Room(200 + i));
        }
    }

    public void collectFood() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Room room = rooms.get(random.nextInt(rooms.size()));
            if (room.tryLock()) {
                if (room.hasFood()) {
                    getFoodFromRoom(room);
                    break;
                }
                room.unlock();
            }
        }
    }

    private void getFoodFromRoom(Room room) {
        collectedFood.addAll(room.removeAllFood());
        log.info(Thread.currentThread().getName() + " collected food from room " + room.getNumber());
        cdl.countDown();
    }

    public int sizeRooms() {
        return rooms.size();
    }
}