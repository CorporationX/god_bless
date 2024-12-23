package school.faang.sprint_3.task_48477;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class House {
    private final String name;
    private final List<Room> rooms;
    private final List<Food> collectedFood;
    @Setter
    CountDownLatch roomCounter;

    public House(String name) {
        this.name = name;
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("The room is empty!");
        }
        rooms.add(room);
        log.info("{} successfully added", room.getName());
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            for (Room room : rooms) {
                try {
                    if (room.tryLock()) {
                        if (!room.allFoodTaken()) {
                            takeFoodFromTheRoom(room);
                            break;
                        }
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                } finally {
                    room.unlock();
                }
            }
        }
    }


    private void takeFoodFromTheRoom(Room room) {
        collectedFood.addAll(room.pickUpFood());
        log.info("{} collected food from: {}", Thread.currentThread().getName(), room.getName());
        roomCounter.countDown();
    }

    public int sizeHouse() {
        return rooms.size();
    }
}
